package beans;

public class Product {

	long productID;
	String productName;
	String productImg;
	double productPrice;
	String productDescription;
	
	
	
	public Product(long productID, String productName, String productImg, double productPrice,
			String productDescription) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productImg = productImg;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
}
