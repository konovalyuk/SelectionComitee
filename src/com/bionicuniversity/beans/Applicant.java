package com.bionicuniversity.beans;

import java.io.Serializable;


public class Applicant implements Serializable {
	private static final long serialVersionUID = 1L;

	private int user_idUser;

	private int faculty_idFaculty;

	public Applicant() {
	}
	
	public Applicant(int user_idUser, int faculty_idFaculty) {
		this.user_idUser = user_idUser;
		this.faculty_idFaculty = faculty_idFaculty;
	}

	public int getUser_idUser() {
		return this.user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public int getFaculty_idFaculty() {
		return this.faculty_idFaculty;
	}

	public void setFaculty_idFaculty(int faculty_idFaculty) {
		this.faculty_idFaculty = faculty_idFaculty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + faculty_idFaculty;
		result = prime * result + user_idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Applicant))
			return false;
		Applicant other = (Applicant) obj;
		if (faculty_idFaculty != other.faculty_idFaculty)
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Applicant [user_idUser=%s, faculty_idFaculty=%s]", user_idUser,
				faculty_idFaculty);
	}

}