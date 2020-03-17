package ua.lviv.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.xml.DOMConfigurator;

public abstract class Connector {
	private static String LOGIN = "test";
	private static String PASSWORD = "12345";
	private static String URL = "jdbc:mysql://localhost/magaz";

	public static Connection open()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DOMConfigurator.configure("log4j.xml");	
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		return DriverManager.getConnection(URL, LOGIN, PASSWORD);
	}

	public static ResultSet openWithExec(String str)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DOMConfigurator.configure("log4j.xml");	
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		Statement s = c.createStatement();
		return s.executeQuery(str);
	}
}
