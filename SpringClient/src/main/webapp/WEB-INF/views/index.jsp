<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/25/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
response from api:
${value}
<br>
<form action="/getdemo3api" method="post">

    Fullname <input type="text" name="fullnameclient">
    <input type="submit" value="send">
</form>
<%--<h3>Product finded</h3>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>id</th>--%>
<%--        <th>name</th>--%>
<%--        <th>price</th>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <th>${productfinded.id}</th>--%>
<%--        <th>${productfinded.name}</th>--%>
<%--        <th>${productfinded.price}</th>--%>
<%--    </tr>--%>


<%--</table>--%>
<hr>
<h3>All product</h3>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    <c:forEach items="${products}" var="p">
    <tr>
        <th>${p.id}</th>
        <th>${p.name}</th>
        <th>${p.price}</th>
    </tr>
    </c:forEach>


</table>
<hr>
<h3>Product created</h3>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    <tr>
        <th>${productcreated.id}</th>
        <th>${productcreated.name}</th>
        <th>${productcreated.price}</th>
    </tr>


</table>

<hr><h3>Product updated</h3>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    <tr>
        <th>${productupdated.id}</th>
        <th>${productupdated.name}</th>
        <th>${productupdated.price}</th>
    </tr>


</table>
<hr>
<h3>${isdeleted}</h3>

</body>
</html>
