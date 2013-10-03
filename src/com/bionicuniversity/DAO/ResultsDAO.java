package com.bionicuniversity.DAO;

import java.util.ArrayList;

import com.bionicuniversity.beans.Result;

public interface ResultsDAO {

	public boolean add(Result result);
	
	public ArrayList<Integer> getGrades(final int id);
	
	public ArrayList<Integer> getDisciplines(final int id);
}
