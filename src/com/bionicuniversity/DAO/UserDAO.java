<<<<<<< HEAD
package com.bionicuniversity.DAO;

import com.bionicuniversity.beans.User;

public interface UserDAO {
	
	public int checkLogin(final String login, final String password);
	
	public int getId(final String login, final String password);
	
	public String getName(final int id);
	
	public String getSurname(final int id);
	
	public boolean add(User user);
}
=======
package com.bionicuniversity.DAO;

import com.bionicuniversity.beans.User;

public interface UserDAO {
	
	public int checkLogin(final String login, final String password);
	
	public int getId(final String login, final String password);
	
	public String getName(final int id);
	
	public String getSurname(final int id);
	
	public boolean add(User user);
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
