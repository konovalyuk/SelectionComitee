package com.bionicuniversity.DAO;

import java.util.ArrayList;

public interface RequiredDisciplinesDAO {
	
	public ArrayList<Integer> getRequiredDisciplines(final int faculty);
	
	public ArrayList<String> getSizes();
}
