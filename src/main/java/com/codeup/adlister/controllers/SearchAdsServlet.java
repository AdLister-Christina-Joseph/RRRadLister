package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
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

import static javax.servlet.jsp.jstl.core.Config.*;

@WebServlet("/searchAds")
public class SearchAdsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Ads ListAdsDao = DaoFactory.getAdsDao();
            String title = request.getParameter("searchAds");
            List<Ad> adResults = ListAdsDao.byTitle(title);
            request.setAttribute("adResults", adResults);
            System.out.println(adResults);
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}

//
//public String getIsEmpty(){
//        return"Empty String";
//        }
