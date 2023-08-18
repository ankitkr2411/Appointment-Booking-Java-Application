package myConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import database.Database;

public class SqlConnection {
	
	public static Connection myConn;;
	public static Statement stmt;


	public static void createConnection() throws SQLException
	{
			myConn = DriverManager.getConnection(Database.url+Database.databasename,Database.user,Database.password);
			stmt = myConn.createStatement();
		
	}

}
