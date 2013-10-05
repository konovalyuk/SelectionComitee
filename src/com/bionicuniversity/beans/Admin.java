<<<<<<< HEAD
package com.bionicuniversity.beans;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	private int user_idUser;

	public Admin() {
	}

	public Admin(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public int getUser_idUser() {
		return this.user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Admin))
			return false;
		Admin other = (Admin) obj;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Admin [user_idUser=%s]", user_idUser);
	}

=======
package com.bionicuniversity.beans;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	private int user_idUser;

	public Admin() {
	}

	public Admin(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public int getUser_idUser() {
		return this.user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Admin))
			return false;
		Admin other = (Admin) obj;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Admin [user_idUser=%s]", user_idUser);
	}

>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
}