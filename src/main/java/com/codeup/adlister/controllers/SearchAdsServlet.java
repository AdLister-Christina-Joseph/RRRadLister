package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.util.Password;
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

@WebServlet("/searchAds")
public class SearchAdsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        List<Ad> searchedAds = ListAdsDao.all();
//        Set Dao information

        try {
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Ads ListAdsDao = DaoFactory.getAdsDao();
        String title = request.getParameter("searchAds");
        request.setAttribute("title", ListAdsDao.byTitle(title));

        try {
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}