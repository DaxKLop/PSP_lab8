package by.hvalinskii.controller;

import java.sql.*;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/JSP/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ArrayList<User> users = JDBC.getUsersFromDB();
        int id = 1;
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                req.getRequestDispatcher("WEB-INF/JSP/reg.jsp").forward(req, resp);
            }
            else {
                id++;
            }
        }
        insertUser(id, login, password, "user");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void insertUser(int userId, String login, String password, String role) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "145263");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO users (user_id, login, password, role) VALUES (?, ?, ?, ?)")) {

            statement.setInt(1, userId);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.setString(4, role);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
