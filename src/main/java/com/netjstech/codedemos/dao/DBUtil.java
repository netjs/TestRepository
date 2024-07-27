package com.netjstech.codedemos.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {
	private final static String PROPERTIES_FILE_NAME = "db.properties";
	//private static HikariDataSource ds;
	private static Properties properties = null;
	static {
		try {
			properties = new Properties();
			// Loading properties file from classpath
			InputStream inputStream = DBUtil.class
                                         	.getClassLoader()
                                         	.getResourceAsStream(PROPERTIES_FILE_NAME);
			if(inputStream == null){
				throw new IOException("File not found");
			}
			properties.load(inputStream);	
			// Create DataSource
			//ds = new getDataSourceConnection;
		} catch(IOException e) {
		      e.printStackTrace();
	    }     
	}
	
//	public static DataSource getDataSource() {
//		return ds;
//	} 
	
	
//	public static DataSource getDataSourceConnection() throws SQLException{
//		Properties properties = loadProperties();
//		HikariConfig config = new HikariConfig();
//
//		// HikariConfig is the configuration class 
//		//used to initialize a data source.
//		//HikariConfig config = new HikariConfig();
//		// This property is optional now 
//		config.setDriverClassName(properties.getProperty("DB_DRIVER"));
//		config.setJdbcUrl(properties.getProperty("DB_URL"));
//		config.setUsername(properties.getProperty("DB_USERNAME"));
//		config.setPassword(properties.getProperty("DB_PASSWORD"));
//		config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("MAX_POOL_SIZE")));
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		//This sets the number of prepared statements that the 
//		//MySQL driver will cache per connection.
//		config.addDataSourceProperty("prepStmtCacheSize", "250");
//		//This is the maximum length of a prepared SQL statement 
//		//that the driver will cache
//		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//		
//		return new HikariDataSource(config);
//	}
	
	
	public static Connection getDBConnection() throws SQLException{
		//Properties prop = loadProperties();
		Connection connection = null;
		try {
			String driverName = properties.getProperty("DB_DRIVER");
			Class.forName(driverName);
			String dbUrl = properties.getProperty("DB_URL");
			String user = properties.getProperty("DB_USERNAME");
			String pwd = properties.getProperty("DB_PASSWORD");
			connection = DriverManager.getConnection (dbUrl, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	private static Properties loadProperties() {

		InputStream propsFile;
		Properties dbProperties = new Properties();

		try {
			propsFile = new FileInputStream(PROPERTIES_FILE_NAME);
			dbProperties.load(propsFile);
			propsFile.close();
		} catch (IOException ioe) {
			System.out.println("I/O Exception.");
			ioe.printStackTrace();
			//System.exit(0);
		}
		return dbProperties;
	}
}
