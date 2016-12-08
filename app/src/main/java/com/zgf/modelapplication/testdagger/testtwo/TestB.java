package com.zgf.modelapplication.testdagger.testtwo;

import javax.inject.Inject;

/**
 * Created by zgf on 2016/12/2.
 */

public class TestB {
    private TestA a;

    @Inject
    public TestB(TestA a) {
        this.a = a;
    }

    public String b() {
        return a.a();
    }
}
