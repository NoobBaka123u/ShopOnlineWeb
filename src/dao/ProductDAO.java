package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Category;
import model.Product;

public class ProductDAO {

	public ArrayList<Product> getListProductByCategory(long category_id) throws SQLException {
        Connection connection = DBConnection.getDatabaseConnection();
        String sql = "SELECT * FROM product WHERE category_id = '" + category_id + "'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getLong("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDescription(rs.getString("product_description"));
            list.add(product);
        }
        return list;
    }

	public Product getProduct(long parseLong) {
		Connection connection = DBConnection.getDatabaseConnection();
        String sql = "SELECT * FROM product WHERE product_id = '" + parseLong + "'";
        Product p = null;
        try {
			Statement statement = connection.createStatement();
			ResultSet set =statement.executeQuery(sql);
			while(set.next())
			{
				p = new Product();
				p.setProductID(set.getLong("product_id"));
				p.setCategoryID(set.getLong("category_id"));
				p.setProductDescription(set.getString("product_description"));
				p.setProductImage(set.getString("product_image"));
				p.setProductName(set.getString("product_name"));
				p.setProductPrice(set.getDouble("product_price"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return p;
	}
	public ArrayList<Product> getListProduct() throws SQLException {
        Connection connection = DBConnection.getDatabaseConnection();
        String sql = "SELECT * FROM product";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getLong("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDescription(rs.getString("product_description"));
            product.setCategoryID(rs.getLong("category_id"));
            list.add(product);
        }
        return list;
    }
	public boolean insert(Product p) throws SQLException {
	    try {
	         Connection connection = DBConnection.getDatabaseConnection();
	         String sql = "insert into product (product_name,product_image,product_price,product_description,category_id) values(?,?,?,?,?)";
	         PreparedStatement statement = connection.prepareStatement(sql);
	       //  statement.setLong(1, c.getCategoryID());
	         statement.setString(1, p.getProductName());
	         statement.setString(2, p.getProductImage());
	         statement.setDouble(3, p.getProductPrice());
	         statement.setString(4, p.getProductDescription());
	         statement.setLong(5, p.getCategoryID());
	         int temp = statement.executeUpdate();
	         if(temp==0)return false;
	         else return true;
	    } catch (Exception e) {
	        System.out.println(e.getMessage()+"loi");
	    	return false;
	    }
		}
	public boolean update(Product p) throws SQLException {
	    try {
	         Connection connection = DBConnection.getDatabaseConnection();
	         String sql = "UPDATE product SET product_name = ?,"
	         		+ "product_image=?,"
	         		+ "product_price=?,"
	         		+ "product_description=?,"
	         		+ "category_id=?"
	         		+ " WHERE product_id = ?";
	         PreparedStatement statement = connection.prepareStatement(sql);
		       //  statement.setLong(1, c.getCategoryID());
		         statement.setString(1, p.getProductName());
		         statement.setString(2, p.getProductImage());
		         statement.setDouble(3, p.getProductPrice());
		         statement.setString(4, p.getProductDescription());
		         statement.setLong(5, p.getCategoryID());
		         statement.setLong(6, p.getProductID());
	         int temp = statement.executeUpdate();
	         return temp == 1;
	    } catch (Exception e) {
	    	System.out.println(e);
	         return false;
	    }
	}
	public boolean delete(long product_id) throws SQLException {
	    try {
	        Connection connection = DBConnection.getDatabaseConnection();
	        String sql = "DELETE FROM product WHERE product_id = ?";
	        PreparedStatement ps = connection.prepareCall(sql);
	        ps.setLong(1, product_id);
	        int temp = ps.executeUpdate();
	            return temp == 1;
	    } catch (Exception e) {
	    	System.out.println(e);
	        return false;
	    }
	}
}
