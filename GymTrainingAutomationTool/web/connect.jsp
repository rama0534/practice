<%--
  Created by IntelliJ IDEA.
  User: rama
  Date: 8/5/20
  Time: 3:28 pm
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page import="java.sql.*"%>
<%@ page import="java.lang.String" import="java.util.*"%>

<%
    String userid =request.getParameter("userid");
    String emailid =request.getParameter("emailid");
    String password =request.getParameter("password");

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymtraining","root","Rama1234");
    PreparedStatement ps = conn.prepareStatement("insert into users(userid, emailid, password) values (?,?,?)");
    ps.setString(1,userid);
    ps.setString(2,emailid);
    ps.setString(3,password);
    int x = ps.executeUpdate();
    if (x>0){
        out.println("Registration success");
    }else {
        out.println("unsuccessful");
    }



}catch (Exception e){
    out.println(e);
}






%>


















