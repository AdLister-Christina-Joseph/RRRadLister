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


@WebServlet(name = "controllers.EditServlet", urlPatterns = "/ads/edit")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //checking to see if someone is logged in
        //class example did this in the doPost he said do both bc people can try to figure out workarounds
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/loginError");
            return;
        }
        String adIDString = request.getParameter("id");
        Long id = Long.parseLong(adIDString);

        request.setAttribute("ad", DaoFactory.getAdsDao().individualAd(id));

        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String adIDString = request.getParameter("id");
        Long id = Long.parseLong(adIDString);

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            System.out.println("Not logged in.");
            response.sendRedirect("/loginError");
            //or could just redirect to login page
            return;
        }


        Ad ad = new Ad(
                id,
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        DaoFactory.getAdsDao().edit(ad);
        response.sendRedirect("/profile");
    }
}
