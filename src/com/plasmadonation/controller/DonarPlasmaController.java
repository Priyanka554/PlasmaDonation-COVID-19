package com.plasmadonation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plasmadonation.dao.DonarPlasmaDAO;
import com.plasmadonation.model.DonarPlasma;
import com.plasmadonation.model.User;

/*
 * Saving Donate Plasma Request Controller
 */

@WebServlet("/donar")
public class DonarPlasmaController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * Reading input values from request object Passing input values to DAO class
		 * Alert messages displaying using SWAL
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
		String lastDayCovidBefore14days = req.getParameter("lastDayCovidBefore14days");
		String lastDateOfSymptom = req.getParameter("date");
		String covidTest = req.getParameter("covidTest");
		String role = "";

		/*
		 * Creating User Object
		 */
		User user = new User(firstName, lastName, email, role, password, gender, streetAddress, addressLine1, state,
				city, postalCode, country);

		/*
		 * Creating Donarplasma Object
		 */
		DonarPlasma donarPlasma = new DonarPlasma(user, bloodGroup, confirmedTest, currentlySymptoms,
				lastDayCovidBefore14days, lastDateOfSymptom, covidTest);

		DonarPlasmaDAO donarPlasmaDAO = new DonarPlasmaDAO();

		int success = donarPlasmaDAO.addDonarPlasmaUser(donarPlasma);

		PrintWriter out = resp.getWriter();

		if (success == 1) {

			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Requested Successfully','','success');");

			out.println("});");

			out.println("</script>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("DonatePlasma.jsp");
			requestDispatcher.include(req, resp);
		} else {

			out.println(
					"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

			out.println("<script>");

			out.println("$(document).ready(function(){");

			out.println("swal('Something Went Wrong','Try Again','error');");

			out.println("});");

			out.println("</script>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("DonatePlasma.jsp");
			requestDispatcher.include(req, resp);
		}

	}

}
