package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.IndividualAdServlet", urlPatterns = "/individualAd")
public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //got ad data
        String idString = request.getParameter("id");
        Long id = Long.parseLong(idString);

        request.setAttribute("ad", DaoFactory.getAdsDao().individualAd(id));

        Ad ad = DaoFactory.getAdsDao().individualAd(id);
        Long userID = ad.getUserId();

        //now i need to get user data
        User user = (User) DaoFactory.getUsersDao().findByUserID(userID);

        String username = user.getUsername();

        request.setAttribute("username", username);
        request.setAttribute("userID", userID);


        request.getRequestDispatcher("/WEB-INF/ads/individualAd.jsp").forward(request, response);
    }
}
