package com.plasmadonation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plasmadonation.dao.UserLoginDAO;
import com.plasmadonation.model.User;

/*
 * 
 *  Login Controller
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	/*
	 * 
	 * Retrive email and password from request object. Passing email and password to
	 * DAO class. Checking role and forwarding request based on role
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserLoginDAO userLoginDAO = new UserLoginDAO();

		User user = userLoginDAO.doLogin(email, password);

		PrintWriter out = resp.getWriter();
		if (user != null) {

			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
			httpSession.setAttribute("firstName", user.getFirstName());
			httpSession.setAttribute("lastName", user.getLastName());
			httpSession.setAttribute("email", user.getEmail());
			httpSession.setAttribute("password", user.getPassword());
			httpSession.setAttribute("gender", user.getGender());
			httpSession.setAttribute("streetAddress", user.getStreetAddress());
			httpSession.setAttribute("addressLine1", user.getAddressLine2());
			httpSession.setAttribute("city", user.getCity());
			httpSession.setAttribute("province", user.getProvince());
			httpSession.setAttribute("country", user.getCountry());
			httpSession.setAttribute("postalCode", user.getPostalCode());

			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Login Successfull','','success');");

			out.println("});");

			out.println("</script>");

			if (user.getRole().equals("user")) {

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserProfilePage.jsp");
				requestDispatcher.include(req, resp);

			}

			else {

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminProfilePage.jsp");
				requestDispatcher.include(req, resp);

			}

		}

		else {

			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Login Failed','Email or Password Incorrect','error');");

			out.println("});");

			out.println("</script>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);

		}

	}

}
