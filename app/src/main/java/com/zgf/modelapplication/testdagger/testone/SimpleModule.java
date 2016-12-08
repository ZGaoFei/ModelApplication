package com.zgf.modelapplication.testdagger.testone;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zgf on 2016/12/2.
 */

@Module
public class SimpleModule {

    @Provides
    Cooker provideCooker(){
        return new Cooker("James","Espresso");
    }
}
