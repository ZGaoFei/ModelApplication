package com.zgf.modelapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zgf.modelapplication.R;
import com.zgf.modelapplication.base.BaseActivity;
import com.zgf.modelapplication.testdagger.testone.CoffeeMachine;
import com.zgf.modelapplication.testdagger.testone.SimpleModule;
import com.zgf.modelapplication.testdagger.testtwo.DaggerTestComponent;
import com.zgf.modelapplication.testdagger.testtwo.TestB;
import com.zgf.modelapplication.testdagger.testtwo.TestComponent;
import com.zgf.modelapplication.testdagger.testtwo.TestModule;

import javax.inject.Inject;

/**
 * 仿照 DaggerTestActivity 进行编写
 *
 * 初步总结：
 *      总共分为 @Inject @Module @Provides @Component
 *      @Inject：请求依赖(用在构造函数，域或方法)。需要注入的方法。
 *      @Module：用于类，该类的方法提供依赖。作为实例对象的容器。
 *      @Provides：用于@Module注解的类中的方法。标注能够提供实例化对象的方法。
 *      @Component：是模块和注入之间的接口。作为桥梁，注入对象的通道。
 *
 *      @Scope用法：自定义注解限定注解作用域；其实这里就是生命周期的
 *                  @Scopes类定义一个componet或者module的生命周期
 *                  意思通过这个注解我们可以标示一个对象的生命周期
 *      @Singleton：标示当前方法和对象是单利模式
 *
 *      在 Component 中需要标明 Module 和需要注入的 Activity
 *      在编译的时候会自动生成 Dagger<Component name/> 类
 *
 *      如果在一个 Activity 中需要添加多个 Module 时，
 *      可以在 Component 的 @Component(modules = {TestModule.class, SimpleModule.class}) 中添加
 *      同时可以在 Component 中重构 inject(Object) 方法
 *      并且可以单独使用 modules 其中的一个 module 在任意一个对象中
 *      因此可以将同类项的对象放在同一个 Component 中，重构相应的 inject() 方法即可
 *      在 module 里面可以将同类型的对象放入，如 activity，fragment 等
 *
 *
 *
 */
public class DaggerTestTwoActivity extends BaseActivity {
    private TextView textView;
    private TextView textView2;
    private Button button;

    @Inject
    TestB testB;

    @Inject
    CoffeeMachine coffeeMachine;

    private TestComponent testComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test_two);
        initView();
        initData();
        initListener();
    }

    @Override
    protected void initView() {
        textView = (TextView) findViewById(R.id.tv_show_dagger_two);
        textView2 = (TextView) findViewById(R.id.tv_show_dagger_two2);
        button = (Button) findViewById(R.id.bt_dagger_two);
    }

    @Override
    protected void initData() {
        /*testComponent = DaggerTestComponent.builder().testModule(new TestModule()).build();
        testComponent.inject(this);*/

        /*testComponent = DaggerTestComponent.builder().simpleModule(new SimpleModule()).build();
        testComponent.inject(this);*/

        DaggerTestComponent
                .builder()
                .testModule(new TestModule())
                .simpleModule(new SimpleModule())
                .build()
                .inject(this);
    }

    @Override
    protected void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(testB.b());
                textView2.setText(coffeeMachine.makeCoffee());
            }
        });
    }
}
