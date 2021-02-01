package com.plasmadonation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.plasmadonation.dao.DonarPlasmaDAO;
import com.plasmadonation.model.AnalyticsResponse;
import com.plasmadonation.modifications.DateModification;

/*
 * 
 * Retriving Data form database controller
 */

@WebServlet("/donateplasmagraph")
public class DonatePlasmaAnalytics extends HttpServlet {

	/*
	 * 
	 * Retriving Date and Count of request from database.
	 * 
	 * Manipulating Date
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");

		JSONObject map = new JSONObject();
		PrintWriter out = response.getWriter();

		try {
			DonarPlasmaDAO donarPlasmaDAO = new DonarPlasmaDAO();
			List<AnalyticsResponse> analyticsResponses = donarPlasmaDAO.getCountByDate();

			for (AnalyticsResponse analyticsResponse : analyticsResponses) {
				String formattedDate = DateModification.formattingDate(analyticsResponse.getDate());
				map.put(formattedDate, analyticsResponse.getCount());
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.print(map);
	}

}
