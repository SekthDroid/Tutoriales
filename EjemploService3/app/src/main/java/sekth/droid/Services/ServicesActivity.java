package sekth.droid.Services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ServicesActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                startService();
                break;
            case R.id.btn_stop:
                stopService();
                break;
        }
    }

    private void startService() {
        startService(new Intent(this, MyService.class));
    }

    private void stopService() {
        stopService(new Intent(this, MyService.class));
    }
}
