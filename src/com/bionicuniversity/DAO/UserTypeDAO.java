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
