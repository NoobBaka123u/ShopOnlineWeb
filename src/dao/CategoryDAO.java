package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;


public class CategoryDAO {
	
	public ArrayList<Category> getListCategory() {
        Connection con = DBConnection.getDatabaseConnection();
        String sql = "SELECT * FROM category";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps =  con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                list.add(category);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public boolean insert(Category c) throws SQLException {
	    try {
	         Connection connection = DBConnection.getDatabaseConnection();
	         String sql = "insert into category (category_name) values(?)";
	         PreparedStatement statement = connection.prepareStatement(sql);
	       //  statement.setLong(1, c.getCategoryID());
	         statement.setString(1, c.getCategoryName());
	         int temp = statement.executeUpdate();
	         if(temp==0)return false;
	         else return true;
	    } catch (Exception e) {
	        System.out.println(e.getMessage()+"loi");
	    	return false;
	    }
		}
	public boolean update(Category c) throws SQLException {
	    try {
	         Connection connection = DBConnection.getDatabaseConnection();
	         String sql = "UPDATE category SET category_name = ? WHERE category_id = ?";
	         PreparedStatement ps = connection.prepareCall(sql);
	         ps.setString(1, c.getCategoryName());
	         ps.setLong(2, c.getCategoryID());
	         int temp = ps.executeUpdate();
	         return temp == 1;
	    } catch (Exception e) {
	         return false;
	    }
	}
	public boolean delete(long category_id) throws SQLException {
	    try {
	        Connection connection = DBConnection.getDatabaseConnection();
	        String sql = "DELETE FROM category WHERE category_id = ?";
	        PreparedStatement ps = connection.prepareCall(sql);
	        ps.setLong(1, category_id);
	        int temp = ps.executeUpdate();
	            return temp == 1;
	    } catch (Exception e) {
	        return false;
	    }
	}

}
