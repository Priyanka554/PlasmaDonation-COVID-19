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

import com.plasmadonation.dao.UserUpdateDAO;
import com.plasmadonation.model.User;

/*
 * 
 * Update user controller
 */
@WebServlet("/updateuser")
public class UpdateUserController extends HttpServlet {

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
		String addressLine1 = req.getParameter("addressLine1");
		String country = req.getParameter("country");
		String state = req.getParameter("province");
		String city = req.getParameter("city");
		String postalCode = req.getParameter("postalCode");
		String role = "";

		/* Creating User Object */
		User user = new User(firstName, lastName, email, role, password, gender, streetAddress, addressLine1, state,
				city, postalCode, country);

		role = UserUpdateDAO.updateUser(user);

		PrintWriter out = resp.getWriter();

		if (role != null) {

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

			/*
			 * Creating alert message using sweet alert
			 */

			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Updated Successfully','','success');");

			out.println("});");

			out.println("</script>");

			if (role.equalsIgnoreCase("user")) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserProfilePage.jsp");
				requestDispatcher.include(req, resp);
			} else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminProfilePage.jsp");
				requestDispatcher.include(req, resp);

			}
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

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserProfilePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}

}
