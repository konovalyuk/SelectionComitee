package com.bionicuniversity.manager;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class ConnectionManager {
	/*
	 * Charge for connections to the database in whole application using TomCat
	 * v7.0 JDBC Connection Pool. Documentation:
	 * http://people.apache.org/~fhanik/jdbc-pool/jdbc-pool.html
	 * http://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html
	 */

	private static ConnectionManager ConnectionManager = null;
	private DataSource pool = null;
	private PoolProperties p;

	// this constructor executed only ones when getting instance of
	// ConnectionManager. Creates and sets PoolProperties for Connection Pool
	// (that is DataSource)
	private ConnectionManager() {
		p = new PoolProperties();
		p.setUrl(ConfigurationManager.getInstance().getProperty(ConfigurationManager.DATABASE_URL));
		p.setDriverClassName(ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.DATABASE_DRIVER_NAME));

		pool = new DataSource();
		pool.setPoolProperties(p);
	}

	// getting new or free connection from the connection pool
	public Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

	// closing or returning connection to the connection pool
	public void closeConnection(final Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public static ConnectionManager getInstance() {
		if (ConnectionManager == null) {
			ConnectionManager = new ConnectionManager();
		}
		return ConnectionManager;
	}
}
