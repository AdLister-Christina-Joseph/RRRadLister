package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adIDString = request.getParameter("id");
        Long id = Long.parseLong(adIDString);

        request.setAttribute("ad", DaoFactory.getAdsDao().individualAd(id));


        request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idString = request.getParameter("id");
        Long id = Long.parseLong(idString);
        DaoFactory.getAdsDao().deleteAd(id);

        response.sendRedirect("/profile");



    }

}