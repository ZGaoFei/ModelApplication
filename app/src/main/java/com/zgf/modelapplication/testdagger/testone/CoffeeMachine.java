package com.zgf.modelapplication.testdagger.testone;

import javax.inject.Inject;

/**
 * Created by zgf on 2016/12/2.
 */

public class CoffeeMachine {
    private CoffeeMaker maker;

    @Inject
    public CoffeeMachine(Cooker cooker) {
        maker = new SimpleMaker(cooker);
    }

    public String makeCoffee() {
        return maker.makeCoffee();
    }
}
