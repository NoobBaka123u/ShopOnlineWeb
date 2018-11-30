package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.ApplicationDao;
@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email	= req.getParameter("email");
		String username	= req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User(username, password,firstName, lastName, email);
		ApplicationDao dao =new ApplicationDao();
		if(dao.registerUser(user))
		{
			String message = "dang ky thanh cong";
			req.setAttribute("message", message);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		else
		{
			String message = "co loi ";
			req.setAttribute("message", message);
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		}
	};

}