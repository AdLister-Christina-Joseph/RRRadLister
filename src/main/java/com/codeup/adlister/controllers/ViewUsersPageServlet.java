package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.ViewUsersPageServlet", urlPatterns = "/user")
public class ViewUsersPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userIDString = request.getParameter("id");
        Long id = Long.parseLong(userIDString);

        request.setAttribute("adsByUser", DaoFactory.getAdsDao().byUser(id));
        request.setAttribute("user", DaoFactory.getUsersDao().findByUserID(id));

        request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }

}