<<<<<<< HEAD
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.manager.ConnectionManager;

public class FacultyDAOImpl implements FacultyDAO {
	
	static Logger logger = Logger.getLogger(AdminDAOImpl.class);
	
	public ArrayList<String> getFaculties() {
		
		ArrayList<String> faculties = new ArrayList<String>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Faculty_name FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							faculties.add(res.getString("Faculty_name"));
						}
						
						return faculties;
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
			return faculties;
		}
	}
	
	public ArrayList<Integer> getSizes() {
		
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Size FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							sizes.add(res.getInt("Size"));
						}
						
						return sizes;
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
			return sizes;
		}
	}
	
	public ArrayList<Integer> getIds() {
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT idFaculty FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							ids.add(res.getInt("idFaculty"));
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
	
	public Integer getId(final String faculty) {
		Integer ids = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT idFaculty FROM selection.faculty WHERE Faculty_name=?");
					st.setString(1, faculty);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						res.first();
						ids = res.getInt("idFaculty");
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
}
=======
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.manager.ConnectionManager;

public class FacultyDAOImpl implements FacultyDAO {
	
	static Logger logger = Logger.getLogger(AdminDAOImpl.class);
	
	public ArrayList<String> getFaculties() {
		
		ArrayList<String> faculties = new ArrayList<String>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Faculty_name FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							faculties.add(res.getString("Faculty_name"));
						}
						
						return faculties;
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
			return faculties;
		}
	}
	
	public ArrayList<Integer> getSizes() {
		
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Size FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							sizes.add(res.getInt("Size"));
						}
						
						return sizes;
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
			return sizes;
		}
	}
	
	public ArrayList<Integer> getIds() {
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT idFaculty FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							ids.add(res.getInt("idFaculty"));
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
	
	public Integer getId(final String faculty) {
		Integer ids = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT idFaculty FROM selection.faculty WHERE Faculty_name=?");
					st.setString(1, faculty);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						res.first();
						ids = res.getInt("idFaculty");
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
	
	public String getNameById(final int id) {
		String name = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Faculty_name FROM selection.faculty WHERE idFaculty=?");
					st.setInt(1, id);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						res.first();
						name = res.getString("Faculty_name");
						return name;
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
			return name;
		}
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
