package com.morrs.veloxameetingmicroservice.domain.entity;

import com.morrs.veloxameetingmicroservice.domain.values.user.Email;
import com.morrs.veloxameetingmicroservice.domain.values.user.Name;
import com.morrs.veloxameetingmicroservice.domain.values.user.Patronymic;
import com.morrs.veloxameetingmicroservice.domain.values.user.Surname;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

public class User extends BaseEntity {
	private Surname surname;
	private Name name;
	private Patronymic patronymic;
	private Email email;

	public User(UUID id, Surname surname, Name name, Patronymic patronymic, Email email) {
		super(id);
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.patronymic = patronymic;
	}

	public Surname getSurname() {
		return surname;
	}

	public void setSurname(Surname surname) {
		this.surname = surname;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Patronymic getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(Patronymic patronymic) {
		this.patronymic = patronymic;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	@Override
	public void validate() {
	}
}
