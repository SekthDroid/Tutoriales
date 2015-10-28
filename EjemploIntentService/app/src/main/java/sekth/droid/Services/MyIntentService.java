package sekth.droid.Services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super(MyIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent arg0) {
        for (int i = 0; i < 100; i++) {
            Log.d(TAG, "Doing some heavy stuff");
            downloadFileFrom("http://www.google.com/imagen1.png");
        }

        Log.d(TAG, "Finishing IntentService");
    }

    private int downloadFileFrom(String url) {
        try {
            // Simulamos una tarea larga
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return 100;
    }

}
