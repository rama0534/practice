<%--
  Created by IntelliJ IDEA.
  User: rama
  Date: 23/4/20
  Time: 6:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date" %>
<html>
<head>
    <title>Sample JSP page</title>
</head>
<body>
<h3>Testing JSP</h3>

<%!
    public int add(int a, int b) {
      return a+b;

    }
%>
<%
    int i=1;
    int j=4;
    int k;
    k= i+j;
    out.println("the value of K is "+ k);
%>
the value of k is <%=k%>

<%
    k=add(32343, 53452);
    out.println("the value of K is "+ k);
%>

<% for (i=0; i<5; i++)

{

%>
    <br> The new value of i = <%=i%>
<%}%>
<br>
The time is <%= new Date()%>
<br>
<%@include file="/Clock.jsp"%>
</body>
</html>
