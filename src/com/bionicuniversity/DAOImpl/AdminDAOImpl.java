<<<<<<< HEAD
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.AdminDAO;
import com.bionicuniversity.beans.Admin;
import com.bionicuniversity.manager.ConnectionManager;

public class AdminDAOImpl implements AdminDAO {
	
	static Logger logger = Logger.getLogger(AdminDAOImpl.class);
	
	public boolean add(Admin admin) {
		logger.debug("Class AdminDAOImpl, method add start");
		try {
			Connection conn = null;
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = null;

			st = conn
					.prepareStatement("INSERT INTO selection.admin(user_idUser) VALUES(?)");
			st.setInt(1, admin.getUser_idUser());
			st.executeUpdate();
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				ConnectionManager.getInstance().closeConnection(conn);
			}

			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occured due to ", ex);
			return false;
		} finally {
			logger.debug("Class AdminDAOImpl, method add end");
		}
		
	}
}
=======
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.AdminDAO;
import com.bionicuniversity.beans.Admin;
import com.bionicuniversity.manager.ConnectionManager;

public class AdminDAOImpl implements AdminDAO {
	
	static Logger logger = Logger.getLogger(AdminDAOImpl.class);
	
	public boolean add(Admin admin) {
		logger.debug("Class AdminDAOImpl, method add start");
		try {
			Connection conn = null;
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = null;

			st = conn
					.prepareStatement("INSERT INTO selection.admin(user_idUser) VALUES(?)");
			st.setInt(1, admin.getUser_idUser());
			st.executeUpdate();
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				ConnectionManager.getInstance().closeConnection(conn);
			}

			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occured due to ", ex);
			return false;
		} finally {
			logger.debug("Class AdminDAOImpl, method add end");
		}
		
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
