package by.hvalinskii.controller;

import java.sql.*;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class AddCardServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Card> cards = JDBC.getCardsFromDB();
        req.setAttribute("cards", cards);
        req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
    }

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String bornDate = req.getParameter("bornDate");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");


        ArrayList<Card> cards = JDBC.getCardsFromDB();
        int id = 1;
        for (Card card : cards) {
            if (card.getFirst_name().equals(firstName) && card.getLast_name().equals(lastName) && card.getBorn_date().equals(bornDate) && card.getHeight().equals(height) && card.getWeight().equals(weight)) {
                req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
            }
            else {
                id++;
            }
        }
        insertCard(id, firstName, lastName, bornDate, height, weight);
        resp.sendRedirect("/lab_8/addCard");
    }

    public void insertCard(int cardId, String fistName, String lastName, String born_date, String height, String weight) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "145263");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO cards (card_id, firstname, lastname, born_date, height, weight) VALUES (?, ?, ?, ?, ?, ?)")) {


            statement.setLong(1, cardId);
            statement.setString(2, fistName);
            statement.setString(3, lastName);
            statement.setString(4, born_date);
            statement.setString(5, height);
            statement.setString(6, weight);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
