<%--
  Created by IntelliJ IDEA.
  User: rama
  Date: 28/4/20
  Time: 5:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration  Page</title>
</head>
<body>

<form action="Process.jsp" method="post">

    <br> UserId  <input type="text" name="userId" />
    <br> User Name  <input type="text" name="userName" />
    <br> Address Line 1:<input type="text" name="address1" />
    <br> Address Line 1:  <input type="text" name="address2" />
    <br> City  <input type="text" name="city" />
    <br> State  <input type="text" name="state" />
    <br> Pin Code  <input type="text" name="pincode" />

    <br> <input type="submit"/>


</form>
</body>
</html>
