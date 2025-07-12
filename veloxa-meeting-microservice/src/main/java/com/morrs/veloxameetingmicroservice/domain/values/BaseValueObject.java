package com.morrs.veloxameetingmicroservice.domain.values;

public abstract class BaseValueObject<T> {

	protected T value;

	public BaseValueObject(T value) {
		this.value = value;
		this.validate();
	}

	protected abstract void validate();

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
