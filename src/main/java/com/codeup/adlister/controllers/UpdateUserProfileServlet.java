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

import static com.codeup.adlister.util.Password.hash;

@WebServlet(name = "controllers/UpdateUserProfileServlet", urlPatterns = "/profile/edit")
public class UpdateUserProfileServlet extends HttpServlet {

    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("confirm_password") == null) {
            request.getSession().setAttribute("confirm_password", "");
        }

        try {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String newUsername = request.getParameter("new-username");
        String newEmail = request.getParameter("new-email");
        String newPassword = request.getParameter("new-password");
        String passwordConfirmation = request.getParameter("confirm-new-password");
        String hash = hash(newPassword);

        boolean inputHasErrors = (!newPassword.equals(passwordConfirmation));

            User user = (User) request.getSession().getAttribute("user");
            DaoFactory.getUsersDao().updateUser(user, newUsername, newEmail, hash);
            user.setUsername(newUsername);
            user.setEmail(newEmail);
            if (newPassword.equals(passwordConfirmation)) {
                user.setPassword(newPassword);
            }


            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        }
    }