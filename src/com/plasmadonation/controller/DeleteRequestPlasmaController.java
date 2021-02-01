package com.plasmadonation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plasmadonation.dao.RequestPlasmaDAO;

/*
 * Delete Request Plasma Request Controller
 */

@WebServlet("/deleterequestplasma")
public class DeleteRequestPlasmaController extends HttpServlet {

	/*
	 * 
	 * Method for collecting emails from request object Deleting request based on
	 * emails display alert messages using swal
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] emails = req.getParameterValues("checkboxs");
		RequestPlasmaDAO requestPlasmaDAO = new RequestPlasmaDAO();
		int success = 0;
		for (int i = 0; i < emails.length; i++) {
			success = success + requestPlasmaDAO.deleteRequestUser(emails[i]);
		}

		PrintWriter out = resp.getWriter();
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

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("RequestPlasmaList.jsp");
			requestDispatcher.include(req, resp);
		}

	}

}
