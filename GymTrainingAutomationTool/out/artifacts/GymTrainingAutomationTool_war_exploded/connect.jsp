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


    try
    {


//        String url = "jdbc:mysql://localhost:3306/gymtraining?useSSL=false&serverTimezone=UTC";
//        String url= "jdbc:mysql://localhost:3306/gymtraining";
//        String uname = "root";
//        String pass = "Rama1234";
//        Connection con = DriverManager.getConnection(url,uname,pass);
//        Class.forName("com.mysql.cj.jdbc.Driver");

//                Connection cnn = DriverManager.getConnection("jdbc:mysql://localinstance:3306/gymtraining","root","Rama1234");


        String url = "jdbc:mysql://localhost:3306/gymtraining?useSSL=false&serverTimezone=UTC";
        String uname = "root";
        String pass = "Rama1234";

        String query = "select emailid from gymtraining.users";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        out.println("hinnnnn");
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(query);
//
//        rs.next();
//        String name = rs.getString("emailid");
//        System.out.println(name);
//
//        st.close();
//        con.close();











        //
//                PreparedStatement ps = cnn.prepareStatement("insert into gymtraining.users(userid, emailid, password) values (?,?,?)");

//                ps.setString(1,userid);
//                ps.setString(2,emailid);
//                ps.setString(3,password);
//
//                int x = ps.executeUpdate();
//                if (x>0){
//
//                    out.println("Registration successfully");
//                }else {
//                    out.println("Registration Failed");
//                }

    }catch(Exception e)
    {
        out.println(e);
    }


%>


















