package com.example.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        findViewById(R.id.btnStart).setOnClickListener(this);
        findViewById(R.id.btnStop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                startService();
                break;
            case R.id.btnStop:
                stopService();
                break;
        }
    }

    private void startService() {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    private void stopService() {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
