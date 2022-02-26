<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/26/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>CREATE NEW PRODUCT</h2>
<s:form action="" method="post" modelAttribute="product">
    id:
    <s:input type="text" path ="id"/>
    <br>
    name:
    <s:input type="text" path ="name"/>
    <br>
    price:
    <s:input type="text" path ="price"/>
    <br>
   active:
    <s:checkbox path ="active"/>
    <br>
    quanlity:
    <s:input type="text" path ="quanlity"/>
    <br>
    created date:

<%--    <s:input type="date" path="created" />--%>
    <br>
    <br>
    <input type="submit" value="send">

</s:form>

</body>
</html>
