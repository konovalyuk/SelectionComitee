package com.bionicuniversity.DAO;

import java.util.ArrayList;
import com.bionicuniversity.beans.Applicant;

public interface ApplicantDAO {
	public boolean add(Applicant applicant);
	
	public ArrayList<Integer> getIds();
	
	public Integer getFacultyId(final int id);
}
