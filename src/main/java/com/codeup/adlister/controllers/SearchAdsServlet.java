package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class SearchAdsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("searchAds");
//        Set Dao information
        request.setAttribute("ads", DaoFactory.getAdsDao().byTitle(title));
        try {
            request.getRequestDispatcher("/WEB-INF/ads/searchresults.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

}
