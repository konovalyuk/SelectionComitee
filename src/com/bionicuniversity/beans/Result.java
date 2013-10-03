package com.bionicuniversity.beans;

import java.io.Serializable;

public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	private int resultId;

	private int applicant_user_idUser;

	private int disciplines_idSubject;

	private String grade;

	public Result() {
	}

	public Result(int applicant_user_idUser, int disciplines_idSubject, String grade) {
		this.applicant_user_idUser = applicant_user_idUser;
		this.disciplines_idSubject = disciplines_idSubject;
		this.grade = grade;
	}

	public int getResultId() {
		return this.resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getApplicant_user_idUser() {
		return this.applicant_user_idUser;
	}

	public void setApplicant_user_idUser(int applicant_user_idUser) {
		this.applicant_user_idUser = applicant_user_idUser;
	}

	public int getDisciplines_idSubject() {
		return this.disciplines_idSubject;
	}

	public void setDisciplines_idSubject(int disciplines_idSubject) {
		this.disciplines_idSubject = disciplines_idSubject;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + applicant_user_idUser;
		result = prime * result + disciplines_idSubject;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + resultId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Result))
			return false;
		Result other = (Result) obj;
		if (applicant_user_idUser != other.applicant_user_idUser)
			return false;
		if (disciplines_idSubject != other.disciplines_idSubject)
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (resultId != other.resultId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("Result [resultId=%s, applicant_user_idUser=%s, disciplines_idSubject=%s, grade=%s]",
						resultId, applicant_user_idUser, disciplines_idSubject, grade);
	}

}