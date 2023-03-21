package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
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
        Ad ad = DaoFactory.getAdsDao().individualAd(id);
        String title = ad.getTitle();
        HttpSession session = request.getSession();
        if (session.getAttribute("title") == "") {
            request.getSession().setAttribute("title", "");
        } else {
            request.getSession().setAttribute("title", title);
        }

        if (request.getSession().getAttribute("error") == null) {
            String show = "hidden";
            session.removeAttribute("error");
            session.setAttribute("error", show);
        }


        String description = ad.getDescription();
        if (session.getAttribute("description") == "") {
            request.getSession().setAttribute("description", "");
        } else {
            request.getSession().setAttribute("description", description);
        }




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

        HttpSession session = request.getSession();
        Long UserId = user.getId();
        String title = request.getParameter("title");
        String description = request.getParameter("description");


        boolean inputHasErrors = title.isEmpty()
                || description.isEmpty();

        if (inputHasErrors) {
            if (title.isEmpty()) {
                String show = " ";
                session.removeAttribute("error");
                session.setAttribute("error", show);

                session.removeAttribute("title");
                request.getSession().setAttribute("title", "");

                String titleEmpty = "Please enter a title.";
                session.removeAttribute("errorMsg");
                session.setAttribute("errorMsg", titleEmpty);
            }
            if (description.isEmpty()) {
                String show = " ";
                session.removeAttribute("error");
                session.setAttribute("error", show);

                session.removeAttribute("description");
                request.getSession().setAttribute("description", "");

                String descriptionEmpty = "Please enter a description.";
                session.removeAttribute("errorMsg");
                session.setAttribute("errorMsg", descriptionEmpty);
            }

            String tempTitle = request.getParameter("title");
            session.removeAttribute("title");
            session.setAttribute("title", tempTitle);


            String tempDescription = request.getParameter("description");
            session.removeAttribute("description");
            session.setAttribute("description", tempDescription);

            response.sendRedirect("/ads/edit?id=" + id);

        } else {

            Ad ad = new Ad(
                    id,
                    UserId,
                    title,
                    description
            );
            DaoFactory.getAdsDao().edit(ad);
            response.sendRedirect("/profile");
        }


    }



}
