package com.plasmadonation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plasmadonation.dao.UserRegisterDAO;
import com.plasmadonation.model.User;

/*
 * Register Controller
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * Collection input parameters from request object
		 */

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String streetAddress = req.getParameter("streetAddress");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String addressLine1 = req.getParameter("addressLine2");
		String country = req.getParameter("country");
		String state = req.getParameter("provience");
		String city = req.getParameter("city");
		String postalCode = req.getParameter("postalCode");
		String role = "user";

		/* Creating User Object */
		User user = new User(firstName, lastName, email, role, password, gender, streetAddress, addressLine1, state,
				city, postalCode, country);

		int success = UserRegisterDAO.registerUser(user);

		PrintWriter out = resp.getWriter();

		if (success == 1) {

			/*
			 * Creating alert message using sweet alert
			 */

			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Register Successfull','','success');");

			out.println("});");

			out.println("</script>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
		} else {

			/*
			 * Creating alert message using sweet alert
			 */
			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Something Went Wrong','Try Again','error');");

			out.println("});");

			out.println("</script>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Register.jsp");
			requestDispatcher.include(req, resp);
		}
	}

}
