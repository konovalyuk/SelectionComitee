package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bionicuniversity.DAO.ListDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;
import com.bionicuniversity.beans.List;
import com.bionicuniversity.manager.ConnectionManager;

public class ListDAOImpl implements ListDAO {
	public boolean add(List list) {
		try {
			Connection conn = null;
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = null;

			st = conn
					.prepareStatement("INSERT INTO selection.list(applicant_user_idUser, faculty_idFaculty, enrolled) VALUES(?,?,?)");
			st.setInt(1, list.getApplicant_user_idUser());
			st.setInt(2, list.getFaculty_idFaculty());
			st.setBoolean(3, false);
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
			return false;
		}
	}

	public boolean getStatus(final int id) {
		boolean status = false;
		try {
			Connection connect = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT enrolled FROM selection.list WHERE applicant_user_idUser=?");
					ptst.setInt(1, id);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						while (resultSet.next()) {
							status = resultSet.getBoolean("enrolled");
						}
						return status;
					} finally {
						if (resultSet != null) {
							resultSet.close();
						}
					}
				} finally {
					if (ptst != null) {
						ptst.close();
					}
				}
			} finally {
				if (connect != null) {
					ConnectionManager.getInstance().closeConnection(connect);
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return status;
		}
	}

	public void changeStatus(final int id) {
		try {
			Connection conn = null;
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = null;

			st = conn.prepareStatement("UPDATE selection.list SET enrolled=? WHERE applicant_user_idUser=?");
			ListDAO listDAO = new DAOFactory().getListDAO();
			if (listDAO.getStatus(id)) {
				st.setBoolean(1, false);
			} else {
				st.setBoolean(1, true);
			}
			st.setInt(2, id);
			st.executeUpdate();

			if (st != null) {
				st.close();
			}
			if (conn != null) {
				ConnectionManager.getInstance().closeConnection(conn);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
