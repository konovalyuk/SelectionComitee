<<<<<<< HEAD
package com.bionicuniversity.DAO;

import java.util.ArrayList;

public interface FacultyDAO {
	
	public ArrayList<String> getFaculties();
	
	public ArrayList<Integer> getSizes();
	
	public ArrayList<Integer> getIds();
	
	public Integer getId(final String faculty);
}
=======
package com.bionicuniversity.DAO;

import java.util.ArrayList;

public interface FacultyDAO {
	
	public ArrayList<String> getFaculties();
	
	public ArrayList<Integer> getSizes();
	
	public ArrayList<Integer> getIds();
	
	public Integer getId(final String faculty);
	
	public String getNameById(final int id);
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
