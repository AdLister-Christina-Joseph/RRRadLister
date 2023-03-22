package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.User;
import com.mysql.cj.api.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

@WebServlet(name = "controllers/UpdateUserProfileServlet", urlPatterns = "/profile/edit")
public class UpdateUserProfileServlet extends HttpServlet {

    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newUsername = request.getParameter("new-username");
        String newEmail = request.getParameter("new-email");
        User user = (User) request.getSession().getAttribute("user");
        DaoFactory.getUsersDao().updateUser(user, newUsername, newEmail);
        user.setUsername(newUsername);
        user.setEmail(newEmail);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/profile");
    }


}

