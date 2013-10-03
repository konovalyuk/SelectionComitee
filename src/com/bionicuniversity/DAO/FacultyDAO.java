package com.bionicuniversity.DAO;

import java.util.ArrayList;

public interface FacultyDAO {
	
	public ArrayList<String> getFaculties();
	
	public ArrayList<Integer> getSizes();
	
	public ArrayList<Integer> getIds();
	
	public Integer getId(final String faculty);
	
	public String getNameById(final int id);
}
