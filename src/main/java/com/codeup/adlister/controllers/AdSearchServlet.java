package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdSearchServlet extends HttpServlet {
    private Connection connection;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.AdSearchDao().all());
        request.getRequestDispatcher("searchField").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchRequest = request.getParameter("searchField");
        if (searchRequest != null && searchRequest.length() > 0) {
            try {
                PreparedStatement searchPS = connection.prepareStatement("SELECT * FROM ads WHERE title = ?");
                ResultSet rs = searchPS.executeQuery();
                searchPS.setString(1, searchRequest); // Bind the value to the placeholder
            } catch (SQLException e) {
                throw new RuntimeException("No Results", e);
            }
        }
    }
}
