package com.plasmadonation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plasmadonation.dao.MailSendingConfigurations;

/*
 * 
 * Email Contact Controller class
 * It will send email to all mails which are checked
 */

@WebServlet("/sendemail")
public class ContactUserController extends HttpServlet {

	/*
	 * Initializing all email related fields
	 */

	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {

		host = "smtp.gmail.com";
		port = "587";
		user = "ucmplasmadonation@gmail.com";
		pass = "Ucmplasma@2020";
	}

	/*
	 * 
	 * Retriving emails from the request Object Passing all email related field and
	 * emails to DAO class Using swal display an alert message based on success or
	 * failure of email sending
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] emails = req.getParameterValues("checkboxs");

		String toMails = "";
		for (int i = 0; i < emails.length; i++) {
			toMails = toMails + emails[i] + ",";
		}

		PrintWriter out = resp.getWriter();

		String message = "<p>Dear Member,</p><br>";
		message += "<p>Thank you for the request.</p>";
		message += "<p>Your request has been reviewed. Please expect a call from our staff soon.</p><br>";
		message += "<p>Best regards,</p>";
		message += "<p>UCM Health Division.</p>";
		message += "<img src=\"WebContent\\img\\UCM.png\"/>";

		try {
			int success = MailSendingConfigurations.sendEmail(host, port, user, pass, toMails,
					"UCM Plasma Donation for Covid-19", message);

			if (success == 1) {
				out.println(
						"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

				out.println("<script>");

				out.println("$(document).ready(function(){");

				out.println("swal('Mails Send Successfully','','success');");

				out.println("});");

				out.println("</script>");

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("ContactUser.jsp");
				requestDispatcher.include(req, resp);
			} else {
				out.println(
						"<script src=' https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");

				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");

				out.println("<script>");

				out.println("$(document).ready(function(){");

				out.println("swal('Mails Send Failed','Something went wrong','error');");

				out.println("});");

				out.println("</script>");

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("ContactUser.jsp");
				requestDispatcher.include(req, resp);
			}

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
