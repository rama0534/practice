<%--
  Created by IntelliJ IDEA.
  User: rama
  Date: 28/4/20
  Time: 6:22 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%!
public void jspInit(){
    String defaultUSer = getServletConfig().getInitParameter("defaultUser");
    ServletContext context = getServletContext();
    context.setAttribute("default",defaultUSer);
}
%>
<body>
The default user from the servlet config is:  <%= getServletConfig().getInitParameter("defaultUser")%>
The value in the Servlet context is : <%=getServletContext().getAttribute("defaultUser")%>
</body>
</html>
