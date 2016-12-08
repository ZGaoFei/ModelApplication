package com.zgf.modelapplication.testdagger.testone;

import com.zgf.modelapplication.ui.activity.DaggerTestActivity;

import dagger.Component;

/**
 * Created by zgf on 2016/12/2.
 */

@Component(modules = SimpleModule.class)
public interface SimpleComponent {
    void inject(DaggerTestActivity simpleActivity);
}
