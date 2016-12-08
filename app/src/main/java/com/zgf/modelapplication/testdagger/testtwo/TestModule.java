package com.zgf.modelapplication.testdagger.testtwo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zgf on 2016/12/2.
 */

@Module
public class TestModule {

    @Provides
    TestA provideTest() {
        return new TestA();
    }

    @Provides
    TestB provideTestB(TestA testA) {
        return new TestB(testA);
    }
}
