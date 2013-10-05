<<<<<<< HEAD
package com.bionicuniversity.DAO;

import java.util.ArrayList;

import com.bionicuniversity.beans.UserType;

public interface UserTypeDAO {

	public boolean add(UserType userType);
	
	public String getType(final int id);
	
	public ArrayList<String> getTypes();
	
	public Integer getId(final String type);
	
	public boolean checkType(final int id);
}
=======
package com.bionicuniversity.DAO;

import java.util.ArrayList;

import com.bionicuniversity.beans.UserType;

public interface UserTypeDAO {

	public boolean add(UserType userType);
	
	public String getType(final int id);
	
	public ArrayList<String> getTypes();
	
	public Integer getId(final String type);
	
	public boolean checkType(final int id);
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
