package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("adminname");
		String password = request.getParameter("password");
		AdminDAO dao = new AdminDAO();
		boolean check=dao.checkLogin(username, password);
		
		if(check)
			{
			HttpSession session = request.getSession();
			session.setAttribute("admin", username);
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
			}
		else request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
	}

}
