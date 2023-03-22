package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.codeup.adlister.util.Password.hash;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            request.getSession().setAttribute("username", "");
        }
        if (session.getAttribute("email") == null) {
            request.getSession().setAttribute("email", "");
        }
        if (session.getAttribute("password") == null) {
            request.getSession().setAttribute("password","");
        }
        if (session.getAttribute("confirm_password") == null) {
            request.getSession().setAttribute("confirm_password","");
        }

        if (request.getSession().getAttribute("errorR") == null) {
            String show = "hidden";
            session.removeAttribute("errorR");
            session.setAttribute("errorR", show);
        }

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hash = hash(password);
        String passwordConfirmation = request.getParameter("confirm_password");
        // validate input
        boolean inputHasErrors = username.isEmpty()
            || DaoFactory.getUsersDao().isUnique(username)
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));



        if (inputHasErrors) {
            if (DaoFactory.getUsersDao().isUnique(username)) {
                String show = " ";
                session.removeAttribute("errorR");
                session.setAttribute("errorR", show);

                String titleEmpty = "Please enter a unique username.";
                session.removeAttribute("msgR");
                session.setAttribute("msgR", titleEmpty);

            }

            if (username.isEmpty()) {
                String show = " ";
                session.removeAttribute("errorR");
                session.setAttribute("errorR", show);

                String titleEmpty = "Please enter a username.";
                session.removeAttribute("msgR");
                session.setAttribute("msgR", titleEmpty);
            }
            if (email.isEmpty()) {
                String show = " ";
                session.removeAttribute("errorR");
                session.setAttribute("errorR", show);

                String descriptionEmpty = "Please enter an email.";
                session.removeAttribute("msgR");
                session.setAttribute("msgR", descriptionEmpty);
            }





            String tempUsername =  request.getParameter("username");
            session.removeAttribute("username");
            session.setAttribute("username", tempUsername);

            String tempEmail =  request.getParameter("email");
            session.removeAttribute("email");
            session.setAttribute("email", tempEmail);

            String tempPass =  "";
            session.removeAttribute("password");
            session.setAttribute("password", tempPass);

            String tempPassConf =  "";
            session.removeAttribute("confirm_password");
            session.setAttribute("confirm_password", tempPassConf);

            response.sendRedirect("/register");
        } else {
            // create and save a new user
            User user = new User(username, email, hash);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }
    }
}
