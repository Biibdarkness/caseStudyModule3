<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/18/2022
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% DecimalFormat formatter = new DecimalFormat("###,###,###"); %>

<html>
<head>
    <title>quản lý sản phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-1 align-content-lg-start">
            <a href="/products?" class="btn btn-success">Go To Home</a>
        </div>
        <div class="col-5 align-content-lg-start">
            <a href="/products?action=create" class="btn btn-success">Add new product</a>
        </div>
        <div class="col-6 align-content-end ">
            <form method="post" action="/products?action=search" class="float-right">
                <input type="text" placeholder="Search" name="key">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    <div class="row mt-2">
        <p class="col-8 align-content-lg-start"></p>
        <div class="col-2 align-content-lg-start">
<%--            <form class="d-flex" method="post" action="/products?action=showDeActive">--%>
<%--            </form>--%>
            <a href="/products?action=showDeActive" class="btn btn-secondary">Show Stop Trading Product List</a>

        </div>
        <div class="col-2 align-content-lg-start">
<%--            <form class="d-flex" method="post" action="/products?action=showActive">--%>
<%--            </form>--%>
            <a href="/products?action=showActive" class="btn btn-primary">Show Trading Product List</a>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <h4 class="h4">Product List</h4>
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th>ID</th>
                    <th>Product Type</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>
                            <c:out value="${product.idP}" />
                        </td>
                        <td>
                            <c:out value="${product.typeP}" />
                        </td>
                        <td>
                            <c:out value="${product.nameP}" />
                        </td>
                        <td>
                            <c:out value="${product.quantityP}" />
                        </td>
                        <td>
                            <c:out value="${product.priceP}" />
                        </td>
                        <td>
                            <c:out value="${product.descriptionP}" />
                        </td>
                        <td>
                            <c:out value="${product.statusP}" />
                        </td>
                        <td><a href="/products?action=edit&id=${product.idP}" class="btn btn-success">Edit</a>
                            <a href="/products?action=stop&id=${product.idP}" class="btn btn-info">Change
                                Status</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
