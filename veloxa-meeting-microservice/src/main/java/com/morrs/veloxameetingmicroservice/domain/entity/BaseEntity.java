package com.morrs.veloxameetingmicroservice.domain.entity;

import java.util.Objects;
import java.util.UUID;

public abstract class BaseEntity {

	protected UUID id;

	public BaseEntity(UUID id) {
		this.id = id;
		validate();
	}

	public abstract void validate();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		BaseEntity that = (BaseEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
