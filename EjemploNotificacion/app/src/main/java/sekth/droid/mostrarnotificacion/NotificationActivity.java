package sekth.droid.mostrarnotificacion;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class NotificationActivity extends Activity implements View.OnClickListener {
    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);

        findViewById(R.id.btn_show).setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_show) {
            displayNotification();
        }
    }

    protected void displayNotification() {
        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        CharSequence ticker = "Nueva entrada en SekthDroid";
        CharSequence contentTitle = "SekthDroid";
        CharSequence contentText = "Visita ahora SekthDroid!";
        Notification noti = new NotificationCompat.Builder(this)
                .setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.drawable.ic_launcher)
                .addAction(R.drawable.ic_launcher, ticker, pendingIntent)
                .setVibrate(new long[]{100, 250, 100, 500})
                .build();
        nm.notify(notificationID, noti);
    }

}
