package com.example.ussl_22.thirdday_customnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 1234;
    EditText toTextView,fromTextView,subTextView,msgTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        toTextView = (EditText) findViewById(R.id.to_edit_text);
        fromTextView = (EditText) findViewById(R.id.from_edit_text);
        subTextView = (EditText) findViewById(R.id.sub_edit_text);
        msgTextView = (EditText) findViewById(R.id.msg_edit_text);
    }

    public void sendMessage(View view) {
        if(view.getId()==R.id.send_button){
            String toStr = toTextView.getText().toString();
            String fromStr = fromTextView.getText().toString();
            String subStr = subTextView.getText().toString();
            String messageStr = msgTextView.getText().toString();
            notification.setSmallIcon(R.drawable.ic_launcher);

            notification.setWhen(System.currentTimeMillis());
            notification.setTicker("you have got an email");
            notification.setContentTitle("Email from" + fromStr);
            notification.setContentText(subStr);
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(uniqueID,notification.build());

        }
    }
}
