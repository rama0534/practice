<%--
  Created by IntelliJ IDEA.
  User: rama
  Date: 30/4/20
  Time: 4:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <jsp:useBean id="user" class="org.rama.User" scope="request">
   <jsp:setProperty name="user" property="*"   />

 </jsp:useBean>

Hello <jsp:getProperty name="user" property="userName"/>
Address 1: <jsp:getProperty name="user" property="address1"/>
Address 2:<jsp:getProperty name="user" property="address2"/>
City : <jsp:getProperty name="user" property="city"/>
State: <jsp:getProperty name="user" property="state"/>
pincode: <jsp:getProperty name="user" property="pincode"/>
</body>
</html>
