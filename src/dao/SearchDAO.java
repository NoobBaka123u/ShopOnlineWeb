package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class SearchDAO {

	public List<Product> searchProducts(String searchString) {
		Product product = null;
		List<Product> products = new ArrayList<>();

		try {
			Connection connection = DBConnection.getDatabaseConnection();

			String sql = "select * from product where product_name like '%" + searchString + "%'";

			Statement statement = connection.createStatement();

			ResultSet set = statement.executeQuery(sql);

			while (set.next()) {
				product = new Product();
				product.setProductID(set.getLong("product_id"));
	            product.setProductName(set.getString("product_name"));
	            product.setProductImage(set.getString("product_image"));
	            product.setProductPrice(set.getDouble("product_price"));
	            product.setProductDescription(set.getString("product_description"));
	            product.setCategoryID(set.getLong("category_id"));
				products.add(product);

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return products;
	}
}
