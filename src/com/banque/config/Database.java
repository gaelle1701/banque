package com.banque.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	
	private static Database instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3308/banque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "";
 
    
    public Connection getConnection() {
    	return connection;
    }

	public Database() throws SQLException {	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException ex) {
			System.out.println("Erreur création database" + ex.getMessage());
		}
	}
	
	 public static Database getInstance() throws SQLException {	 
	    if(instance == null) {
	    	instance = new Database();
	    	
	    } else if (instance.getConnection().isClosed()) {
	    		instance = new Database();
	    }
	    return instance;
	}

	

}
