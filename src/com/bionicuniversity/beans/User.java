package com.bionicuniversity.beans;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idUser;

	private String login;

	private String name;

	private String password;

	private String surname;

	private int user_type_User_type;

	public User() {
	}

	public User(final String login, final String name, final String password, final String surname,
			final int user_type_User_type) {
		this.login = login;
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.user_type_User_type = user_type_User_type;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUser_type_User_type() {
		return this.user_type_User_type;
	}

	public void setUser_type_User_type(int user_type_User_type) {
		this.user_type_User_type = user_type_User_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + user_type_User_type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (idUser != other.idUser)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (user_type_User_type != other.user_type_User_type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("User [idUser=%s, login=%s, name=%s, password=%s, surname=%s, user_type_User_type=%s]",
						idUser, login, name, password, surname, user_type_User_type);
	}

}