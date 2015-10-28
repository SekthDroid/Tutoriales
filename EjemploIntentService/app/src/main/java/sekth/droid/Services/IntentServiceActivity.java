package sekth.droid.Services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class IntentServiceActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.btn_start).setOnClickListener(this);
    }

    public void startService() {
        startService(new Intent(getBaseContext(), MyIntentService.class));
    }

    @Override
    public void onClick(View v) {
		if (v.getId() == R.id.btn_start){
            startService();
        }
    }
}
