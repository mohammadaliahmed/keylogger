package com.appsinventiv.keylogger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.DataOutputStream;

public class MainActivity extends AppCompatActivity {
    Button accc;
    private class Startup extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // this method is executed in a background thread
            // no problem calling su here
//            enableAccessibility();
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate");

        setContentView(R.layout.activity_main);
        accc=findViewById(R.id.accc);

        accc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
            }
        });

        (new Startup()).execute();
    }


}
