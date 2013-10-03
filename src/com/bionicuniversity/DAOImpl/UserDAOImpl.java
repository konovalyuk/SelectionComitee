package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.beans.User;
import com.bionicuniversity.manager.ConnectionManager;

public class UserDAOImpl implements UserDAO {
	
	public int checkLogin(final String login, final String password) {
		try {
			Connection conn = null;
			Integer userType = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn
							.prepareStatement("SELECT user_type_User_type FROM selection.user WHERE LOGIN=? AND PASSWORD=?");
					st.setString(1, login);
					st.setString(2, password);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						/*res.first();
						return Integer.parseInt(res.getString("user_type_User_type"));*/
						
						while (res.next()) {
							userType = Integer.parseInt(res.getString("user_type_User_type"));
						}
						return userType;
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
			return 0;
		}
	}
	
	public int getId(final String login, final String password) {
		try {
			Connection connect = null;
			Integer id = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT idUser FROM selection.user WHERE LOGIN=?  AND PASSWORD=?");
					ptst.setString(1, login);
					ptst.setString(2, password);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						/*resultSet.first();
						return Integer.parseInt(resultSet.getString("idUser"));*/
						
						while (resultSet.next()) {
							id = Integer.parseInt(resultSet.getString("idUser"));
						}
						return id;
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
			return 0;
		}
	}
	
	public String getName(final int id) {
		try {
			String name = null;
			Connection connect = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT Name FROM selection.user WHERE idUser=?");
					ptst.setInt(1, id);
					//ptst.setString(2, name);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						while(resultSet.next()) {
							name = resultSet.getString("Name");
						}
						return name;
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
			return null;
		}
	}
	
	public String getSurname(final int id) {
		try {
			Connection connect = null;
			String surname = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT Surname FROM selection.user WHERE idUser=?");
					ptst.setInt(1, id);
					//ptst.setString(2, name);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						while(resultSet.next()) {
							surname = resultSet.getString("Surname");
						}
						return surname;
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
			return null;
		}
	}
	
	public boolean add(User user) {
		try {
			Connection conn = null;
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = null;

			st = conn
					.prepareStatement("INSERT INTO selection.user(Login, Password, Name, Surname, user_type_User_type) VALUES(?,?,?,?,?)");
			st.setString(1, user.getLogin());
			st.setString(2, user.getPassword());
			st.setString(3, user.getName());
			st.setString(4, user.getSurname());
			st.setInt(5, user.getUser_type_User_type());
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
}
