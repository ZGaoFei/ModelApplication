package com.zgf.modelapplication.testdagger.testtwo;

import com.zgf.modelapplication.testdagger.testone.SimpleModule;
import com.zgf.modelapplication.ui.activity.DaggerTestTwoActivity;

import dagger.Component;

/**
 * Created by zgf on 2016/12/2.
 */

@Component(modules = {TestModule.class, SimpleModule.class})
public interface TestComponent {
    void inject(DaggerTestTwoActivity activity);
}
