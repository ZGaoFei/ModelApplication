package com.zgf.modelapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zgf.modelapplication.R;

public class NextActivity extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        
        bt = (Button) findViewById(R.id.bt_even_bus);
        
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2016/11/29 skip
//                EventBus.getDefault().post(new StringEvent("back data!"));
//                EventBus.getDefault().post(new AbsEvent<IntEvent>(new IntEvent(5)));
            }
        });
    }
}
