package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}
