package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databaseconnection {

	private final String SqlUrl = "jdbc:mysql://localhost:3306/sys";  //"localhost:3306/sys" sys DB hosted in local environment 
	private final String UserName = "Your SQLDB User name";
	private final String Password = "Your SQLDB Password";
	private final String Jdbc_Driver = "com.mysql.jdbc.Driver";
	private Connection Connection = null;
	private Statement Statement = null;

	/**
	 *Createconnection function will initiate the 
	 * SQL connection to MYSQL DB
	 * 
	 * */
	public void createconnection() {
		try {

			Class.forName(Jdbc_Driver);
			Connection = DriverManager.getConnection(SqlUrl, UserName, Password);
			Statement = Connection.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * CloseConnection function will
	 * Terminate the sql connection once query executed
	 * 
	 * */

	private void closeconnection() {
		try {
			Connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * InsertStatement function will add
	 * given values to the specified Database
	 * */
	public String insertstatement(String query) {
		createconnection();

		try {

			Statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeconnection();
		return "Inserted successfully!!!";

	}

	/**
	 * Deletestatement function will delete
	 * required row from the database
	 * 
	 * */
	public String deletestatement(String query) {
		createconnection();
		try {

			Statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeconnection();
		return "Deleted successfully !!!";
	}
	/**
	 * Updatetatement function will delete
	 * required row from the database
	 * 
	 * */
	
	public String updatestatement(String query) {
		createconnection();
		try {
			Statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeconnection();
		return "Updated Successfully";
	}

	public String viewstatement(String query) {
		createconnection();
		try {
			ResultSet rs = Statement.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeconnection();

		return "null ";

	}

}
