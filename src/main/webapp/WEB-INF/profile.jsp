<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2 {
            color: #333;
            margin-top: 20px;
        }

        p, h3 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #003366; /* BMW Blue */
            color: #fff;
        }

        a {
            color: #003366; /* BMW Blue */
            text-decoration: none;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>User Profile</h2>
    <c:if test="${not empty loggedInUser}">
        <p>Username: ${loggedInUser.username}</p>
        <h3>Your Offers</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Bid Amount</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="offer" items="${userOffers}">
                    <tr>
                        <td>${offer.product.name}</td>
                        <td>${offer.amount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="${pageContext.request.contextPath}/home">Back to Home</a>
</body>
</html>