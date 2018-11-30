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
	public void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();
		for (Category ds: dao.getListCategory()) {
			System.out.println(ds.getCategoryID()+" "+ds.getCategoryName());
		}
	}

}
