package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

	public boolean checkLogin(String username,String password)
	{
		boolean check=false;
		
		try {
			Connection con = DBConnection.getDatabaseConnection();
			String sql = "select * from admin where username='"+username+"' and password='"+password+"'";
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
}
