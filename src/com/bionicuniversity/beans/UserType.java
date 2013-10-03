package com.bionicuniversity.beans;

import java.io.Serializable;

public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	private int user_type;

	private String type;

	public UserType() {
	}

	public int getUser_type() {
		return this.user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + user_type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserType))
			return false;
		UserType other = (UserType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user_type != other.user_type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("UserType [user_type=%s, type=%s]", user_type, type);
	}

}