<%--
  Created by IntelliJ IDEA.
  User: rama
  Date: 28/4/20
  Time: 5:39 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Objects</title>
</head>
<body>
<%
    String userName= request.getParameter("name");


if (userName != null) {
    session.setAttribute("sessionUserName", userName);
    application.setAttribute("applicationUserName", userName);
    pageContext.setAttribute("pageContextUserName", userName);

}
        %>

<br>
user name in the request object is : <%=userName%>
<br>
user name in the session object is : <%=session.getAttribute("sessionUserName")%>
<br>
user name in the context object is : <%=application.getAttribute("applicationUserName")%>
<br>
user name in the page context  object is : <%=pageContext.getAttribute("pageContextUserName")%>
<br>
</body>
</html>
