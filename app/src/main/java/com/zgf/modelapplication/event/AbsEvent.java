package com.zgf.modelapplication.event;

public class AbsEvent<T> {
    private T t;

    public AbsEvent (T t) {
        this.t = t;
    }

    public T getEvent() {
        return t;
    }

    public void setEvent(T t) {
        this.t = t;
    }
}
