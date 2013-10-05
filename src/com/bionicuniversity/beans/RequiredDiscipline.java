<<<<<<< HEAD
package com.bionicuniversity.beans;

import java.io.Serializable;

public class RequiredDiscipline implements Serializable {
	private static final long serialVersionUID = 1L;

	private int requiredDisciplineId;

	private int disciplines_idSubject;

	private int faculty_idFaculty;

	public RequiredDiscipline() {
	}

	public int getRequiredDisciplineId() {
		return this.requiredDisciplineId;
	}

	public void setRequiredDisciplineId(int requiredDisciplineId) {
		this.requiredDisciplineId = requiredDisciplineId;
	}

	public int getDisciplines_idSubject() {
		return this.disciplines_idSubject;
	}

	public void setDisciplines_idSubject(int disciplines_idSubject) {
		this.disciplines_idSubject = disciplines_idSubject;
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
		result = prime * result + disciplines_idSubject;
		result = prime * result + faculty_idFaculty;
		result = prime * result + requiredDisciplineId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RequiredDiscipline))
			return false;
		RequiredDiscipline other = (RequiredDiscipline) obj;
		if (disciplines_idSubject != other.disciplines_idSubject)
			return false;
		if (faculty_idFaculty != other.faculty_idFaculty)
			return false;
		if (requiredDisciplineId != other.requiredDisciplineId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("RequiredDiscipline [requiredDisciplineId=%s, disciplines_idSubject=%s, faculty_idFaculty=%s]",
						requiredDisciplineId, disciplines_idSubject, faculty_idFaculty);
	}

=======
package com.bionicuniversity.beans;

import java.io.Serializable;

public class RequiredDiscipline implements Serializable {
	private static final long serialVersionUID = 1L;

	private int requiredDisciplineId;

	private int disciplines_idSubject;

	private int faculty_idFaculty;

	public RequiredDiscipline() {
	}

	public int getRequiredDisciplineId() {
		return this.requiredDisciplineId;
	}

	public void setRequiredDisciplineId(int requiredDisciplineId) {
		this.requiredDisciplineId = requiredDisciplineId;
	}

	public int getDisciplines_idSubject() {
		return this.disciplines_idSubject;
	}

	public void setDisciplines_idSubject(int disciplines_idSubject) {
		this.disciplines_idSubject = disciplines_idSubject;
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
		result = prime * result + disciplines_idSubject;
		result = prime * result + faculty_idFaculty;
		result = prime * result + requiredDisciplineId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RequiredDiscipline))
			return false;
		RequiredDiscipline other = (RequiredDiscipline) obj;
		if (disciplines_idSubject != other.disciplines_idSubject)
			return false;
		if (faculty_idFaculty != other.faculty_idFaculty)
			return false;
		if (requiredDisciplineId != other.requiredDisciplineId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("RequiredDiscipline [requiredDisciplineId=%s, disciplines_idSubject=%s, faculty_idFaculty=%s]",
						requiredDisciplineId, disciplines_idSubject, faculty_idFaculty);
	}

>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
}