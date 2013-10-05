<<<<<<< HEAD
package com.bionicuniversity.beans;

import java.io.Serializable;

public class Discipline implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idSubject;

	private String subject;

	public Discipline() {
	}

	public int getIdSubject() {
		return this.idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSubject;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Discipline))
			return false;
		Discipline other = (Discipline) obj;
		if (idSubject != other.idSubject)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Discipline [idSubject=%s, subject=%s]", idSubject, subject);
	}

=======
package com.bionicuniversity.beans;

import java.io.Serializable;

public class Discipline implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idSubject;

	private String subject;

	public Discipline() {
	}

	public int getIdSubject() {
		return this.idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSubject;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Discipline))
			return false;
		Discipline other = (Discipline) obj;
		if (idSubject != other.idSubject)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Discipline [idSubject=%s, subject=%s]", idSubject, subject);
	}

>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
}