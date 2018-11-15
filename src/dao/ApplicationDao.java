package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class ApplicationDao {

	public boolean checkLogin(String username,String password)
	{
		boolean check=false;
		
		try {
			Connection con = DBConnection.getDatabaseConnection();
			String sql = "select * from users where username='"+username+"' and password='"+password+"'";
			PreparedStatement statement = con.prepareStatement(sql);
		//	statement.setString(1, username);
		//	statement.setString(2, password);
			ResultSet set=statement.executeQuery();
			while(set.next())
			{
				check = true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		
	}
	public boolean registerUser(User user)
	{
		int rowsAffected = 0;

		try {
			// get the connection for the database
			Connection connection = DBConnection.getDatabaseConnection();

			// write the insert query
			String insertQuery = "insert into users values(?,?,?,?,?)";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());

			// execute the statement
			rowsAffected = statement.executeUpdate();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		if(rowsAffected==0)return false;
		else return true;
	}
}
