package com.zgf.modelapplication.testdagger.testone.statement;

import com.zgf.modelapplication.testdagger.testone.CoffeeMaker;

/**
 * Created by zgf on 2016/12/2.
 */

public class CoffeeMachineWithInjection implements InjectMaker {
    private CoffeeMaker maker;

    /**
     * 依赖注入的3种常见形式
     * No.1  构造函数注入
     */
    public CoffeeMachineWithInjection(CoffeeMaker maker) {
        this.maker = maker;
    }

    // No.2  Setter注入
    public void setCoffeeMaker(CoffeeMaker maker) {
        this.maker = maker;
    }

    // No.3 接口注入
    @Override
    public void injectMaker(CoffeeMaker maker) {
        this.maker = maker;
    }

    public String makeCoffee() {
        return maker.makeCoffee();
    }
}
