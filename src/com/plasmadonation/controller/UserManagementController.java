package com.plasmadonation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plasmadonation.dao.UserDeleteDAO;

/*
 * 
 * User delete controller
 */
@WebServlet("/user")
public class UserManagementController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] emails = req.getParameterValues("checkboxs");
		PrintWriter out = resp.getWriter();
		if (emails.length > 0) {
			int success = 0;
			UserDeleteDAO userDeleteDAO = new UserDeleteDAO();
			for (int i = 0; i < emails.length; i++) {
				success = success + userDeleteDAO.deleteUser(emails[0]);
			}

			if (success == emails.length) {
				/*
				 * Creating a alert Message Using SweetAlert
				 */
				out.println(
						"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

				out.println("<script>");

				out.println("$(document).ready(function(){");

				out.println("swal('Successfully Deleted','','success');");

				out.println("});");

				out.println("</script>");

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserDetails.jsp");
				requestDispatcher.include(req, resp);
			}

			else {
				/*
				 * Creating a alert Message Using SweetAlert
				 */
				out.println(
						"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

				out.println("<script>");

				out.println("$(document).ready(function(){");

				out.println("swal('Something went wrong ','Try again','error');");

				out.println("});");

				out.println("</script>");

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserDetails.jsp");
				requestDispatcher.include(req, resp);
			}

		} else {
			/*
			 * Creating a alert Message Using SweetAlert
			 */
			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Bad Request ','Please Select Atleast one','error');");

			out.println("});");

			out.println("</script>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserDetails.jsp");
			requestDispatcher.include(req, resp);
		}
	}

}
