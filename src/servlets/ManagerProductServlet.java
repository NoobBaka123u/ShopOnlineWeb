package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Category;
import model.Product;


@WebServlet("/ManagerProductServlet")
public class ManagerProductServlet extends HttpServlet {
	

	ProductDAO dao  = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String product_id = request.getParameter("product_id");
        
        String url = "";
        try {
            switch (command) {

            case "update":
            	String tensp = request.getParameter("tensp");
                String hinhAnh = request.getParameter("hinhAnh");
                String gia = request.getParameter("gia");
                String moTa = request.getParameter("moTa");
                String iddanhmuc=request.getParameter("IDDanhMuc");
                if (tensp.equals("")||hinhAnh.equals("")||gia.equals("")||moTa.equals("")||iddanhmuc.equals("")) 
                {
                	url = "/admin/update_product.jsp";
                	 break;
                }
                dao.update(new Product(Long.parseLong(product_id),Long.parseLong(iddanhmuc), tensp, hinhAnh, Double.parseDouble(gia), moTa));
                url = "/admin/manager_product.jsp";
                break;
                case "delete":
                    dao.delete(Long.parseLong(product_id));
                    url = "/admin/manager_product.jsp";
                    break;
            }
        } catch (Exception e) {
        	System.out.println(e.toString());
        }
        request.getRequestDispatcher(url).forward(request, response);
        
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String tensp = request.getParameter("tensp");
        String hinhAnh = request.getParameter("hinhAnh");
        String gia = request.getParameter("gia");
        String moTa = request.getParameter("moTa");
        String iddanhmuc=request.getParameter("IDDanhMuc");

        String url = "", error = "";
        if (tensp.equals("")||hinhAnh.equals("")||gia.equals("")||moTa.equals("")||iddanhmuc.equals("")) {
            error = "Nhap day du thong tin!";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
               
                    
                      //  boolean b=categoryDAO.insert(new Category(new Date().getTime(), tenDanhMuc));
                    	boolean b=dao.insert(new Product(Long.parseLong(iddanhmuc), tensp, hinhAnh, Double.parseDouble(gia), moTa));
                    	System.out.println(b);
                        url = "/admin/manager_product.jsp";
            } else {
                url = "/admin/insert_product.jsp";
            }
        } catch (Exception e) {
        	
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
		
	}

}
