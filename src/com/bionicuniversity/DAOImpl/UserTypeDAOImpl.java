<<<<<<< HEAD
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bionicuniversity.DAO.UserTypeDAO;
import com.bionicuniversity.beans.UserType;
import com.bionicuniversity.manager.ConnectionManager;

public class UserTypeDAOImpl implements UserTypeDAO {

	public boolean add(UserType userType) {
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("INSERT INTO selection.user_type(User_type, Type) VALUES(?,?)");
					st.setInt(1, userType.getUser_type());
					st.setString(2, userType.getType());
					st.executeUpdate();
					ResultSet res = null;
					try {
						res = st.executeQuery();
						return res.next();
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
			return false;
		}
	}
	
	public String getType(final int id) {
		try {
			String type = null;
			Connection connect = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT Type FROM selection.user_type WHERE User_type=?");
					ptst.setInt(1, id);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						while(resultSet.next()) {
							type = resultSet.getString("Type");
						}
						return type;
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
	
	public ArrayList<String> getTypes() {
		
		ArrayList<String> types = new ArrayList<String>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Type FROM selection.user_type");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							types.add(res.getString("Type"));
						}
						
						return types;
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
			return types;
		}
	}
	
	public Integer getId(final String type) {
		Integer ids = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT User_type FROM selection.user_type WHERE Type=?");
					st.setString(1, type);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							ids = res.getInt("User_type");
						}
						return ids;
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
			return ids;
		}
	}
	
	public boolean checkType(final int id) {
		try {
			Connection connect = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT Type FROM selection.user_type WHERE User_type=?");
					ptst.setInt(1, id);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						return true;
					} catch (NullPointerException e) {
						e.printStackTrace();
						return false;
					}
					finally {
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
			return false;
		}
	}
}
=======
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bionicuniversity.DAO.UserTypeDAO;
import com.bionicuniversity.beans.UserType;
import com.bionicuniversity.manager.ConnectionManager;

public class UserTypeDAOImpl implements UserTypeDAO {

	public boolean add(UserType userType) {
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("INSERT INTO selection.user_type(User_type, Type) VALUES(?,?)");
					st.setInt(1, userType.getUser_type());
					st.setString(2, userType.getType());
					st.executeUpdate();
					ResultSet res = null;
					try {
						res = st.executeQuery();
						return res.next();
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
			return false;
		}
	}
	
	public String getType(final int id) {
		try {
			String type = null;
			Connection connect = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT Type FROM selection.user_type WHERE User_type=?");
					ptst.setInt(1, id);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						while(resultSet.next()) {
							type = resultSet.getString("Type");
						}
						return type;
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
	
	public ArrayList<String> getTypes() {
		
		ArrayList<String> types = new ArrayList<String>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Type FROM selection.user_type");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							types.add(res.getString("Type"));
						}
						
						return types;
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
			return types;
		}
	}
	
	public Integer getId(final String type) {
		Integer ids = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT User_type FROM selection.user_type WHERE Type=?");
					st.setString(1, type);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							ids = res.getInt("User_type");
						}
						return ids;
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
			return ids;
		}
	}
	
	public boolean checkType(final int id) {
		try {
			Connection connect = null;
			try {
				connect = ConnectionManager.getInstance().getConnection();
				PreparedStatement ptst = null;
				try {
					ptst = connect
							.prepareStatement("SELECT Type FROM selection.user_type WHERE User_type=?");
					ptst.setInt(1, id);
					ResultSet resultSet = null;
					try {
						resultSet = ptst.executeQuery();
						return true;
					} catch (NullPointerException e) {
						e.printStackTrace();
						return false;
					}
					finally {
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
			return false;
		}
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
