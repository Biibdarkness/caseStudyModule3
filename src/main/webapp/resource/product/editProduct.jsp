<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/18/2022
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="products?action=products">List All Products</a>
    </h2>
</center>
<div class="container-fluid mt-3">
    <h4 class="mb-1">Edit Product</h4>
    <hr>
    <form method="post">
        <div>
            <c:if test="${product != null}">
                <input type="hidden" name="idP" value = "<c:out value='${product.idP}'/>"/>
            </c:if>
        </div>
        <div class=" form-row">
            <p class="form-group col-sm-1"></p>
            <div class="form-group col-sm-2">
                <label for="Type">Type</label>
                <select name="typeP" id="Type" class="form-control">
                    <option selected value="Skin Care">Skin Care</option>
                    <option value="Body Care">Body Care</option>
                    <option value="Hair Care">Hair Care</option>
                    <option value="Lip Care">Lip Care</option>
                    <option value="Functional Food">Functional Food</option>

                </select>
            </div>
            <div class="form-group col-sm-3">
                <label for="Name">Name</label>
                <input value="<c:out value='${product.nameP}' />" name="nameP" id="Name" type="text"
                       class="form-control">
            </div>
            <div class="form-group col-sm-1">
                <label for="Quantity">Quantity</label>
                <input value="<c:out value='${product.quantityP}'/>" onkeypress='check(event,this,10000)' name="quantityP" id="Quantity" data-toggle="tooltip" data-placement="top"
                       title="Only Number and Less than 10,000 " type="text" class="form-control" >
            </div>
            <div class="form-group col-sm-1">
                <label for="Price">Price</label>
                <input value="<c:out value='${product.priceP}'/>" onkeypress='check(event,this,100000000)' name="priceP" id="Price" data-toggle="tooltip" data-placement="top" title="Only Number and Less than 100,0000,000"
                       type="text" class="form-control" >
            </div>
        </div>
        <div class="form-row">
            <p class="form-group col-sm-1"></p>
            <div class="form-group col-sm-7">
                <label for="descriptionP">Description</label>
                <input value="<c:out value='${product.descriptionP}'/>" name="descriptionP" type="text"
                       class="form-control" id="descriptionP">
            </div>
            <p class="form-group col-sm-1"></p>
            <button type="buttom" class="btn btn-success form-group col-sm-1">UPDATE</button>
        </div>

    </form>
</div>
<script>
    function check(e, a, price) {
        console.log(price)

        if (isNaN(e.key)) {
            e.preventDefault()
        } else {
            const value = a.value + e.key;
            if (+value > price) {
                e.preventDefault()
            }
            console.log(value)
        }
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
