package com.zgf.modelapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.zgf.modelapplication.R;

public class LoggerTestActivity extends AppCompatActivity {
    private static final String TAG = LoggerTestActivity.class.getSimpleName();

    private Button btLogger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger_test);

        btLogger = (Button) findViewById(R.id.bt_log_cat);
        btLogger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logShow();
//                changeTag();
            }
        });
    }

    private void logShow() {
        Logger.d("hello world");
        Logger.e("hello world");
        Logger.w("hello world");
        Logger.v("hello world");
        Logger.wtf("hello world");
        Logger.json("{\n" +
                "    \"people\":[\n" +
                "        {\"firstName\":\"Brett\",\"lastName\":\"McLaughlin\",\"email\":\"aaaa\"},\n" +
                "        {\"firstName\":\"Jason\",\"lastName\":\"Hunter\",\"email\":\"bbbb\"},\n" +
                "        {\"firstName\":\"Elliotte\",\"lastName\":\"Harold\",\"email\":\"cccc\"}\n" +
                "    ]\n" +
                "}");
    }

    private void changeTag() {
        Logger.init(TAG)
        .methodOffset(3).hideThreadInfo().logLevel(LogLevel.NONE);
        Logger.d("hello world");
    }
}
