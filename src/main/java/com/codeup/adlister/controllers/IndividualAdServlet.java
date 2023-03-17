package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
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

        //now i need to get user data
        /*User user = (User) request.getSession().getAttribute("user");
        Long userId = user.getId();
        System.out.println(user.getId());*/

        request.getRequestDispatcher("/WEB-INF/ads/individualAd.jsp").forward(request, response);
    }
}
