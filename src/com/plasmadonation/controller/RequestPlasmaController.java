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
import com.plasmadonation.model.RequestPlasma;
import com.plasmadonation.model.User;

/*
 * 
 * Storing request plasma request
 */
@WebServlet("/request")
public class RequestPlasmaController extends HttpServlet {

	/*
	 * 
	 * Retrive Data from request object passess data to DAO class.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * Retriving input data from request object
		 */

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String streetAddress = req.getParameter("streetAddress");
		String password = "";
		String gender = req.getParameter("gender");
		String addressLine1 = req.getParameter("addressLine2");
		String country = req.getParameter("country");
		String state = req.getParameter("province");
		String city = req.getParameter("city");
		String postalCode = req.getParameter("postalCode");
		String bloodGroup = req.getParameter("bloodgroup");
		String confirmedTest = req.getParameter("confirmedTest");
		String currentlySymptoms = req.getParameter("currentlySymptoms");
		String firstSymptomDate = req.getParameter("firstSymptomDate");
		String[] symptomsEntered = req.getParameterValues("symptoms");
		String symptoms = "";
		String role = "";

		for (int i = 0; i < symptomsEntered.length; i++) {
			symptoms = symptoms + symptomsEntered[i] + ",";
		}

		/*
		 * Creating User Object
		 */

		User user = new User(firstName, lastName, email, role, password, gender, streetAddress, addressLine1, state,
				city, postalCode, country);

		/*
		 * Creating RequestPlasma Object
		 */
		RequestPlasma requestPlasma = new RequestPlasma(bloodGroup, confirmedTest, currentlySymptoms, firstSymptomDate,
				symptoms, user);

		/*
		 * Creating RequestPlasmaDAO object
		 */

		RequestPlasmaDAO requestPlasmaDAO = new RequestPlasmaDAO();
		int success = requestPlasmaDAO.addRequestPlasmaUser(requestPlasma);

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

			out.println("swal('Requested Successfully','','success');");

			out.println("});");

			out.println("</script>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("RequestPlasma.jsp");
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

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("RequestPlasma.jsp");
			requestDispatcher.include(req, resp);
		}

	}

}
