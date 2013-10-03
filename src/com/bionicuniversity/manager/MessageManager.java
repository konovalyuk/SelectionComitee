package com.bionicuniversity.manager;

import java.util.ResourceBundle;

public class MessageManager {
	/* Charge for every message on the view part of application */

	private static MessageManager instance;
	private ResourceBundle resourceBundle;

	private String BUNDLE_NAME = "com.bionicuniversity.manager.messages_en-US";
	public static final String LOGIN_ERROR_MESSAGE = "LOGIN_ERROR_MESSAGE";
	public static final String SERVLET_EXCEPTION_ERROR_MESSAGE = "SERVLET_EXCEPTION_ERROR_MESSAGE";
	public static final String IO_EXCEPTION_ERROR_MESSAGE = "IO_EXCEPTION_ERROR_MESSAGE";
	public static final String MENU_HOME = "MENU_HOME";
	public static final String MENU_LOGIN = "MENU_LOGIN";
	public static final String MENU_LOGOUT = "MENU_LOGOUT";
	public static final String MENU_REGISTER = "MENU_REGISTER";
	public static final String MENU_LIST = "MENU_LIST";
	public static final String MENU_ADMIN_LIST = "MENU_ADMIN_LIST";
	public static final String INDEX_HEADER = "INDEX_HEADER";
	public static final String INDEX_CONTENT = "INDEX_CONTENT";
	public static final String REGISTER_HEADER = "REGISTER_HEADER";
	public static final String REGISTER_LOGIN = "REGISTER_LOGIN";
	public static final String REGISTER_PASSWORD = "REGISTER_PASSWORD";
	public static final String REGISTER_NAME = "REGISTER_NAME";
	public static final String REGISTER_SURNAME = "REGISTER_SURNAME";
	public static final String REGISTER_USER_TYPE = "REGISTER_USER_TYPE";
	public static final String REGISTER_PROCEED = "REGISTER_PROCEED";
	public static final String REGISTER_ERROR_MESSAGE = "REGISTER_ERROR_MESSAGE";
	public static final String LIST_HEADER = "LIST_HEADER";
	public static final String LIST_APPLICANT = "LIST_APPLICANT";
	public static final String LIST_GRADE = "LIST_GRADE";
	public static final String LIST_SIZE_MAX = "LIST_SIZE_MAX";
	public static final String LIST_SIZE = "LIST_SIZE";
	public static final String ADMIN_LIST_HEADER = "ADMIN_LIST_HEADER";
	public static final String ADMIN_LIST_APPLICANT = "ADMIN_LIST_APPLICANT";
	public static final String ADMIN_LIST_GRADE = "ADMIN_LIST_GRADE";
	public static final String ADMIN_LIST_STATUS = "ADMIN_LIST_STATUS";
	public static final String ADMIN_LIST_STATUS_T = "ADMIN_LIST_STATUS_T";
	public static final String ADMIN_LIST_STATUS_F = "ADMIN_LIST_STATUS_F";
	public static final String ADMIN_LIST_SIZE_MAX = "ADMIN_LIST_SIZE_MAX";
	public static final String ADMIN_LIST_SIZE = "ADMIN_LIST_SIZE";
	public static final String ADMIN_LIST_CHANGE_STATUS = "ADMIN_LIST_CHANGE_STATUS";

	// getting instance of MessageManager and setting it Budle
	public static MessageManager getInstance() {
		if (instance == null) {
			instance = new MessageManager();
			instance.resourceBundle = ResourceBundle.getBundle(instance.BUNDLE_NAME);
		}
		instance.resourceBundle = ResourceBundle.getBundle(instance.BUNDLE_NAME);
		return instance;
	}

	// getting value of appropriate field
	public String getProperty(String key) {
		return (String) resourceBundle.getObject(key);
	}

	// switching the Bundle name and calling for instance wich is setting Budle
	public void setBundle() {
		if (BUNDLE_NAME.equalsIgnoreCase("com.bionicuniversity.manager.messages_ru-RU")) {
			BUNDLE_NAME = "com.bionicuniversity.manager.messages_en-US";
			getInstance();
		} else {
			BUNDLE_NAME = "com.bionicuniversity.manager.messages_ru-RU";
			getInstance();
		}
	}
}
