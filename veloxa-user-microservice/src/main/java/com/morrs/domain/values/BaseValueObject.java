package com.morrs.domain.values;

public abstract class BaseValueObject<T> {

    protected T value;

    public BaseValueObject(T value) {
        this.value = value;
        validate();
    }

    public abstract void validate();

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
