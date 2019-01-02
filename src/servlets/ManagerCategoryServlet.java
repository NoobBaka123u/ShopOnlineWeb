package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import dao.CategoryDAO;

@WebServlet("/ManagerCategoryServlet")
public class ManagerCategoryServlet extends HttpServlet {
	
	CategoryDAO categoryDAO = new CategoryDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        String command = request.getParameter("command");
	        String category_id = request.getParameter("category_id");
	        String tenDanhMuc = request.getParameter("tenDanhMuc");
	        String url = "";
	        try {
	            switch (command) {

	            case "update":
                    categoryDAO.update(new Category(Long.parseLong(request.getParameter("category_id")),
                           tenDanhMuc));
                    url = "/admin/manager_category.jsp";
                    break;
	                case "delete":
	                    categoryDAO.delete(Long.parseLong(category_id));
	                    url = "/admin/manager_category.jsp";
	                    break;
	            }
	        } catch (Exception e) {
	        }
	        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	        rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String tenDanhMuc = request.getParameter("tenDanhMuc");

        String url = "", error = "";
        if (tenDanhMuc.equals("")) {
            error = "Vui lòng nhập tên danh mục!";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
               
                    
                      //  boolean b=categoryDAO.insert(new Category(new Date().getTime(), tenDanhMuc));
                    	boolean b=categoryDAO.insert(new Category( tenDanhMuc));
                    	System.out.println(b);
                        url = "/admin/manager_category.jsp";
            } else {
                url = "/admin/insert_category.jsp";
            }
        } catch (Exception e) {
        	
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);

    }
	}


