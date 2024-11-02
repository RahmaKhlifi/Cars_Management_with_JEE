<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
    <title>Product Details</title>
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

        img {
            max-width: 100%;
            height: auto;
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

        form {
            width: 50%;
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #003366; /* BMW Blue */
            color: #fff;
            cursor: pointer;
            padding: 10px;
            border: none;
            border-radius: 3px;
        }

        a {
            color: #003366; /* BMW Blue */
            text-decoration: none;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Product Details</h2>
    <c:if test="${not empty product}">
        <p> ${product.name}</p>
        <p> <img src="${product.image}" alt="${product.name} Image" width="500"></p>
        <p>Cost: ${product.cost} </p> $
        <h3>Offers</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Bidder</th>
                    <th>Bid Amount</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="offer" items="${productOffers}">
                    <tr>
                        <td>${offer.bidder.username}</td>
                        <td>${offer.amount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <h2>Make a bid !</h2>
    <form action="${pageContext.request.contextPath}/productDetails" method="get">
         <input type="number" name="bidAmount" placeholder="Enter your bid">
         <input type="hidden" name="productName" value="${product.name}">
         <input type="submit" value="Submit Bid"> 
</form>

    <a href="${pageContext.request.contextPath}/home">Back to Home</a>
</body>
</html>