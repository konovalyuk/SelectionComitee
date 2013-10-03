package com.bionicuniversity.beans;

import java.io.Serializable;

public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idFaculty;

	private String faculty_name;

	private int size;

	public Faculty() {
	}

	public int getIdFaculty() {
		return this.idFaculty;
	}

	public void setIdFaculty(int idFaculty) {
		this.idFaculty = idFaculty;
	}

	public String getFaculty_name() {
		return this.faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faculty_name == null) ? 0 : faculty_name.hashCode());
		result = prime * result + idFaculty;
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Faculty))
			return false;
		Faculty other = (Faculty) obj;
		if (faculty_name == null) {
			if (other.faculty_name != null)
				return false;
		} else if (!faculty_name.equals(other.faculty_name))
			return false;
		if (idFaculty != other.idFaculty)
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Faculty [idFaculty=%s, faculty_name=%s, size=%s]", idFaculty,
				faculty_name, size);
	}

}