
<%@ page language="java" contentType="text/html; charset=utf-8"
import="by.herman.controller.Card"
 import="java.util.ArrayList"
  pageEncoding="utf-8"%>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        form {
            width: 300px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: inline-block;
            vertical-align: top;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .card-info {
            display: inline-block;
            vertical-align: top;
            margin-left: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .card-info h5 {
            margin-bottom: 10px;
            color: #333;
        }
    </style>
</head>
<body>
<h2 style="margin-bottom:5px">User page</h2>
<a style="display:flex;justify-content:center" href="login">Exit</a><br><br>

<div class="card-form" style="display: inline-block;">
    <h2>View card</h2>
    <form action="userViewCard" method="post">
        <label for="firstName">FirstName:</label>
        <input type="text" id="firstName" name="firstName" required><br>

        <label for="lastName">LastName:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <input type="submit" value="Find card">
    </form>
</div>

<div class="card-info" style="width:750px;height:230px;margin-top:68px">
    <% Card card = (Card)request.getAttribute("card"); %>
    <% if(card != null ){ %>
            <h5>First name: <%= card.getFirst_name() %></h5>
            <h5>Last name: <%= card.getLast_name() %></h5>
            <h5>Born date: <%= card.getBorn_date() %></h5>
            <h5>Height: <%= card.getHeight() %></h5>
            <h5>Weight: <%= card.getWeight() %></h5>
    <% } %>
</div>

</body>
</html>
