package com.zgf.modelapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zgf.modelapplication.R;
import com.zgf.modelapplication.base.BaseActivity;
import com.zgf.modelapplication.testdagger.testone.CoffeeMachine;
import com.zgf.modelapplication.testdagger.testone.DaggerSimpleComponent;
import com.zgf.modelapplication.testdagger.testone.SimpleComponent;
import com.zgf.modelapplication.testdagger.testone.SimpleModule;

import javax.inject.Inject;

public class DaggerTestActivity extends BaseActivity {
    private Button btDagger;
    private TextView textView;

    @Inject
    CoffeeMachine coffeeMachine;

    private SimpleComponent simpleComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test);

        initView();
        initData();
        initListener();
    }

    @Override
    protected void initView() {
        btDagger = (Button) findViewById(R.id.bt_dagger);
        textView = (TextView) findViewById(R.id.tv_show_dagger);
    }

    @Override
    protected void initData() {
//        Cooker cooker = new Cooker("James", "Espresso");
//        coffeeMachine = new CoffeeMachine(cooker);

        // ================================
        simpleComponent = DaggerSimpleComponent.builder().simpleModule(getModule()).build();
        simpleComponent.inject(this);

    }

    @Override
    protected void initListener() {
        btDagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(makeCoffee());
            }
        });
    }

    private String makeCoffee() {
        return coffeeMachine.makeCoffee();
    }

    private SimpleModule getModule() {
        return new SimpleModule();
    }
}
