<<<<<<< HEAD
package com.bionicuniversity.manager;

import java.util.ResourceBundle;

public class ConfigurationManager {
	/* Charge for page paths */

	private static ConfigurationManager instance;
	private ResourceBundle resourceBundle;

	private static final String BUNDLE_NAME = "com.bionicuniversity.manager.config";
	public static final String DATABASE_DRIVER_NAME = "DATABASE_DRIVER_NAME";
	public static final String DATABASE_URL = "DATABASE_URL";
	public static final String ERROR_PAGE_PATH = "ERROR_PAGE_PATH";
	public static final String MAIN_PAGE_PATH = "MAIN_PAGE_PATH";
	public static final String LOGIN_PAGE_PATH = "LOGIN_PAGE_PATH";
	public static final String REGISTER_FACULTY_PAGE_PATH = "REGISTER_FACULTY_PAGE_PATH";
	public static final String ADMIN_LIST_PAGE_PATH = "ADMIN_LIST_PAGE_PATH";
	public static final String CHECK_USER_PAGE_PATH = "CHECK_USER_PAGE_PATH";

	// getting an object only if its not exist yet
	public static ConfigurationManager getInstance() {
		if (instance == null) {
			instance = new ConfigurationManager();
			instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		return instance;
	}

	// loads appropriate value of requesting field
	public String getProperty(String key) {
		return (String) resourceBundle.getObject(key);
	}
}
=======
package com.bionicuniversity.manager;

import java.util.ResourceBundle;

public class ConfigurationManager {
	/* Charge for page paths */

	private static ConfigurationManager instance;
	private ResourceBundle resourceBundle;

	private static final String BUNDLE_NAME = "com.bionicuniversity.manager.config";
	public static final String DATABASE_DRIVER_NAME = "DATABASE_DRIVER_NAME";
	public static final String DATABASE_URL = "DATABASE_URL";
	public static final String ERROR_PAGE_PATH = "ERROR_PAGE_PATH";
	public static final String MAIN_PAGE_PATH = "MAIN_PAGE_PATH";
	public static final String LOGIN_PAGE_PATH = "LOGIN_PAGE_PATH";
	public static final String REGISTER_FACULTY_PAGE_PATH = "REGISTER_FACULTY_PAGE_PATH";
	public static final String ADMIN_LIST_PAGE_PATH = "ADMIN_LIST_PAGE_PATH";
	public static final String CHECK_USER_PAGE_PATH = "CHECK_USER_PAGE_PATH";

	// getting an object only if its not exist yet
	public static ConfigurationManager getInstance() {
		if (instance == null) {
			instance = new ConfigurationManager();
			instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		return instance;
	}

	// loads appropriate value of requesting field
	public String getProperty(String key) {
		return (String) resourceBundle.getObject(key);
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
