package com.zgf.modelapplication.testdagger.testone;

import javax.inject.Inject;

/**
 * Created by zgf on 2016/12/2.
 */

public class SimpleMaker implements CoffeeMaker {
    private Cooker cooker;

    @Inject
    public SimpleMaker(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public String makeCoffee() {
        return cooker.make();
    }
}
