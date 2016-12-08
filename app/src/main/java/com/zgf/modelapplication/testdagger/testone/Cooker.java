package com.zgf.modelapplication.testdagger.testone;

/**
 * Created by zgf on 2016/12/2.
 */

public class Cooker {
    String name;
    String coffeeKind;

    public Cooker(String name, String coffeeKind) {
        this.name = name;
        this.coffeeKind = coffeeKind;
    }

    public String make() {
        return name + " make " + coffeeKind;
    }
}
