package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //checking to see if someone is logged in
        //class example did this in the doPost he said do both bc people can try to figure out workarounds
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/loginError");
            return;
        }

        HttpSession session = request.getSession();
        if (session.getAttribute("title") == null) {
            request.getSession().setAttribute("title", "");
        }
        if (session.getAttribute("description") == null) {
            request.getSession().setAttribute("description", "");
        }

        if (request.getSession().getAttribute("error") == null) {
            String show = "hidden";
            session.removeAttribute("error");
            session.setAttribute("error", show);
        }


        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (user == null) {
            System.out.println("Not logged in.");
            response.sendRedirect("/loginError");
            //or could just redirect to login page
        }

        boolean inputHasErrors = title.isEmpty()
                || description.isEmpty();

        if (inputHasErrors) {
            if (title.isEmpty()) {
                String show = " ";
                session.removeAttribute("error");
                session.setAttribute("error", show);

                String titleEmpty = "Please enter a title.";
                session.removeAttribute("errorMsg");
                session.setAttribute("errorMsg", titleEmpty);
            }
            if (description.isEmpty()) {
                String show = " ";
                session.removeAttribute("error");
                session.setAttribute("error", show);

                String descriptionEmpty = "Please enter a description.";
                session.removeAttribute("errorMsg");
                session.setAttribute("errorMsg", descriptionEmpty);
            }

            String tempTitle =  request.getParameter("title");
            session.removeAttribute("title");
            session.setAttribute("title", tempTitle);


            String tempDescription =  request.getParameter("description");
            session.removeAttribute("description");
            session.setAttribute("description", tempDescription);

            response.sendRedirect("/ads/create");

        } else {

            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")
            );
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/profile");
        }
    }
}