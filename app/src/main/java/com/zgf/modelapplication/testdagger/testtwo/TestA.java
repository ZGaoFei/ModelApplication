package com.zgf.modelapplication.testdagger.testtwo;

import javax.inject.Inject;

/**
 * Created by zgf on 2016/12/2.
 */

public class TestA {

    @Inject
    public TestA() {

    }

    public String a() {
        return "I am class a";
    }
}
