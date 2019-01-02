package dao;

import  dao.DBConnection;
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
        PreparedStatement ps = connection.prepareCall(sql);
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

	public Product getProduct(long productID) throws SQLException {
        Connection connection = DBConnection.getDatabaseConnection();
        String sql = "SELECT * FROM product WHERE product_id = '" + productID + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while (rs.next()) {
            product.setProductID(rs.getLong("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDescription(rs.getString("product_description"));
        }
        return product;
    }
	public ArrayList<Product> getListProductByNav(long categoryID, int firstResult, int maxResult) throws SQLException{
        Connection connection = DBConnection.getDatabaseConnection();
        String sql = "SELECT * FROM product WHERE category_id = '" + categoryID + "' limit ?,?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, firstResult);
        ps.setInt(2, maxResult);
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
    
	 public int countProductByCategory(long categoryID) throws SQLException{
	        Connection connection = DBConnection.getDatabaseConnection();
	        String sql = "SELECT count(product_id) FROM product WHERE category_id = '" + categoryID + "'";
	        PreparedStatement ps = connection.prepareCall(sql);
	        ResultSet rs = ps.executeQuery();
	        int count = 0;
	        while (rs.next()) {
	            count = rs.getInt(1);
	        }
	        return count;  
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
	public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();
//        for (Product p : dao.getListProductByCategory(3)) {
//            System.out.println(p.getProductID() + " - " + p.getProductName());
//        }
        System.out.println(dao.countProductByCategory(1));
    }
    
}


