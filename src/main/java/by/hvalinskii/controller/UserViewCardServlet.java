package by.hvalinskii.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserViewCardServlet extends HttpServlet {

    private String firstName = "firstName";
    private String lastName = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Card card = JDBC.findCardFromDB(firstName, lastName);
        req.setAttribute("card", card);
        req.getRequestDispatcher("WEB-INF/JSP/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         firstName = req.getParameter("firstName");
         lastName = req.getParameter("lastName");

        resp.sendRedirect("/lab_8/userViewCard");
    }

}
