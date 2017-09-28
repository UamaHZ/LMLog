package com.example.log;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.uama.log.LMLog;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_MSG = "This is a log message";
    private static final String TAG = "Example";
    private static String JSON;
    private static String STRING_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LMLog.DEBUG = true;

        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate---1-");
        Log.i("TAG", "onCreate--1--");
        Log.w("TAG", "onCreate-1---");
        Log.e("TAG", "onCreate---1-");
        LMLog.init(getApplication());
        LMLog.WRITE_TO_File = false;
        init();
    }

    private void init() {
        JSON = getResources().getString(R.string.json);
        STRING_LONG = getString(R.string.string_long);
    }

    public void logWithMsg(View view) {
        LMLog.v(LOG_MSG);
        LMLog.d(LOG_MSG);
        LMLog.i(JSON);
        LMLog.w(STRING_LONG);
        LMLog.e(LOG_MSG);
        LMLog.json(JSON);

    }

    public void logWithTag(View view) {
        LMLog.v(TAG, LOG_MSG);
        LMLog.d(TAG, LOG_MSG);
        LMLog.i(TAG, LOG_MSG);
        LMLog.w(TAG, LOG_MSG);
        LMLog.e(TAG, LOG_MSG);
    }

    public void logWithSetTag(View view) {
        LMLog.TAG = "customTAG";
        LMLog.v(LOG_MSG);
        LMLog.d(LOG_MSG);
        LMLog.i(JSON);
        LMLog.w(STRING_LONG);
        LMLog.e(LOG_MSG);
        LMLog.json(JSON);
    }


}
