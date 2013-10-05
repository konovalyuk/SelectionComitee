<<<<<<< HEAD
package com.bionicuniversity.beans;

import java.io.Serializable;

public class List implements Serializable {
	private static final long serialVersionUID = 1L;

	private int applicant_user_idUser;

	private byte enrolled;

	private int faculty_idFaculty;

	public List() {
	}
	
	public List(int applicant_user_idUser, int faculty_idFaculty) {
		this.applicant_user_idUser = applicant_user_idUser;
		this.faculty_idFaculty = faculty_idFaculty;
	}

	public int getApplicant_user_idUser() {
		return this.applicant_user_idUser;
	}

	public void setApplicant_user_idUser(int applicant_user_idUser) {
		this.applicant_user_idUser = applicant_user_idUser;
	}

	public byte getEnrolled() {
		return this.enrolled;
	}

	public void setEnrolled(byte enrolled) {
		this.enrolled = enrolled;
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
		result = prime * result + applicant_user_idUser;
		result = prime * result + enrolled;
		result = prime * result + faculty_idFaculty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof List))
			return false;
		List other = (List) obj;
		if (applicant_user_idUser != other.applicant_user_idUser)
			return false;
		if (enrolled != other.enrolled)
			return false;
		if (faculty_idFaculty != other.faculty_idFaculty)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("List [applicant_user_idUser=%s, enrolled=%s, faculty_idFaculty=%s]",
				applicant_user_idUser, enrolled, faculty_idFaculty);
	}

=======
package com.bionicuniversity.beans;

import java.io.Serializable;

public class List implements Serializable {
	private static final long serialVersionUID = 1L;

	private int applicant_user_idUser;

	private byte enrolled;

	private int faculty_idFaculty;

	public List() {
	}
	
	public List(int applicant_user_idUser, int faculty_idFaculty) {
		this.applicant_user_idUser = applicant_user_idUser;
		this.faculty_idFaculty = faculty_idFaculty;
	}

	public int getApplicant_user_idUser() {
		return this.applicant_user_idUser;
	}

	public void setApplicant_user_idUser(int applicant_user_idUser) {
		this.applicant_user_idUser = applicant_user_idUser;
	}

	public byte getEnrolled() {
		return this.enrolled;
	}

	public void setEnrolled(byte enrolled) {
		this.enrolled = enrolled;
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
		result = prime * result + applicant_user_idUser;
		result = prime * result + enrolled;
		result = prime * result + faculty_idFaculty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof List))
			return false;
		List other = (List) obj;
		if (applicant_user_idUser != other.applicant_user_idUser)
			return false;
		if (enrolled != other.enrolled)
			return false;
		if (faculty_idFaculty != other.faculty_idFaculty)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("List [applicant_user_idUser=%s, enrolled=%s, faculty_idFaculty=%s]",
				applicant_user_idUser, enrolled, faculty_idFaculty);
	}

>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
}