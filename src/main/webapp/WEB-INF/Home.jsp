<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
    <title>Home</title>
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

        h1 {
            color: #004080; /* Lighter blue */
            margin-top: 20px;
        }

        h2, p, h3 {
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

        img {
            max-width: 100%;
            height: auto;
        }

        form {
            width: 50%;
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        input {
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
        }
    </style>
</head>

<body>
    <h1>Welcome : BMW Shop </h1>
    <table border="1">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Image</th>
                <th>Minimal Cost ($)</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${allProducts}">
                <tr>
                    <td>${product.name}</td>
                    <td><img src="${product.image}" alt="${product.name} Image" width="500"></td>
                    <td>${product.cost}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/productDetails" method="get">
                            <input type="hidden" name="productName" value="${product.name}">
                            <input type="submit" value="Details">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h1>You can add a BMW car for sale here</h1>
    <form action="${pageContext.request.contextPath}/home" method="get">
        <label for="productName">Product Name:</label>
        <input type="text" name="productName" required><br>
        <label for="productImage">Image URL:</label>
        <input type="text" name="productImage" required><br>
        <label for="productCost">Product Cost ($):</label>
        <input type="text" name="productCost" required><br>
        <input type="submit" value="Add Product">
    </form>
</body>
</html>