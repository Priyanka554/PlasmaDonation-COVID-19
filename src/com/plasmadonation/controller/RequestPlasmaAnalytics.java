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

import com.plasmadonation.dao.RequestPlasmaDAO;
import com.plasmadonation.model.AnalyticsResponse;
import com.plasmadonation.modifications.DateModification;

/*
 * Retriving request plasma data like date and count controller
 */
@WebServlet("/requestplasmagraph")
public class RequestPlasmaAnalytics extends HttpServlet {

	/*
	 * 
	 * Retrive Data from database maps and to json object
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		JSONObject map = new JSONObject();
		PrintWriter out = response.getWriter();
		RequestPlasmaDAO requestPlasmaDAO = new RequestPlasmaDAO();
		List<AnalyticsResponse> analyticsResponses = requestPlasmaDAO.getCountByDate();

		try {

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
