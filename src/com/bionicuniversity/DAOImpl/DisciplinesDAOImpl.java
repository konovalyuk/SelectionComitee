<<<<<<< HEAD
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.DisciplinesDAO;
import com.bionicuniversity.manager.ConnectionManager;

public class DisciplinesDAOImpl implements DisciplinesDAO {
	
	static Logger logger = Logger.getLogger(DisciplinesDAOImpl.class);

	public String getDiscipline(final int id) {
		logger.debug("Class DisciplinesDAOImpl, method getDiscipline start");
		String discipline = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn
							.prepareStatement("SELECT Subject FROM selection.disciplines WHERE idSubject=?");
					st.setInt(1, id);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						res.first();
						discipline = res.getString("Subject");

						return discipline;
					} finally {
						if (res != null) {
							res.close();
						}
					}
				} finally {
					if (st != null) {
						st.close();
					}
				}
			} finally {
				if (conn != null) {
					ConnectionManager.getInstance().closeConnection(conn);
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occured due to ", ex);
			return discipline;
		} finally {
			logger.debug("Class DisciplinesDAOImpl, method getDiscipline start");
		}
	}
}
=======
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.DisciplinesDAO;
import com.bionicuniversity.manager.ConnectionManager;

public class DisciplinesDAOImpl implements DisciplinesDAO {
	
	static Logger logger = Logger.getLogger(DisciplinesDAOImpl.class);

	public String getDiscipline(final int id) {
		logger.debug("Class DisciplinesDAOImpl, method getDiscipline start");
		String discipline = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn
							.prepareStatement("SELECT Subject FROM selection.disciplines WHERE idSubject=?");
					st.setInt(1, id);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						res.first();
						discipline = res.getString("Subject");

						return discipline;
					} finally {
						if (res != null) {
							res.close();
						}
					}
				} finally {
					if (st != null) {
						st.close();
					}
				}
			} finally {
				if (conn != null) {
					ConnectionManager.getInstance().closeConnection(conn);
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occured due to ", ex);
			return discipline;
		} finally {
			logger.debug("Class DisciplinesDAOImpl, method getDiscipline start");
		}
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
