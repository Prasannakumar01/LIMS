package org.NewaInsurance_GenrericUtilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is to establish connection with the database and disconnect with the data base
 * 
 * @author prasanna
 *
 */

public class DatabaseUtilities {
	Driver driver = null;
	Connection con;
	ResultSet reSet;
	FileUtilities flib = new FileUtilities();
	
	String URL;
	String USERNAME;
	String PASSWORD;
	
	
	/**
	 * This method is essential to register driver with the database and get connection with the mysql database.
	 * @throws SQLException
	 */
	public void connectDB() {
		try {
			URL=flib.getDatafromDbaseconfig("url");
			USERNAME=flib.getDatafromDbaseconfig("username");
			PASSWORD=flib.getDatafromDbaseconfig("password");
	            
			driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is essential to close the database connection in order to improve the performance 
	 * as well as to keep the database safe . 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will execute the query based on the query which is provided in the string format.
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */

	public ResultSet executeQuery(String query) throws SQLException {
		reSet=con.createStatement().executeQuery(query);
		return reSet;

	}

	/**
	 * This method is used to execute the non select query
	 * @param query
	 * @return int
	 * @throws Throwable
	 */
	public int executeUpdate(String query) throws Throwable {

		int reSet = con.createStatement().executeUpdate(query);

		if (reSet == 1) {
			System.out.println("data got created");

		} else {
			System.out.println("data not created");
		}

		return reSet;

	}


	/***
	 * This query is used to execute the query and verify the data based on executed query
	 * @param query
	 * @param cloumnIndex
	 * @param expectedData
	 * @return boolean
	 * @throws Throwable
	 */

	public boolean executeQueryAndVerify(String query,int cloumnIndex,String expectedData) {
		boolean flag=false;
		try {
			reSet=con.createStatement().executeQuery(query);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		try {
			while(reSet.next()) {
				if(reSet.getString(cloumnIndex).equals(expectedData)) {
					flag=true;
					break;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}



	}


}
