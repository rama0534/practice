package ramasadam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet(name = "newSimpleServlet", urlPatterns = "/first")
public class NewSimpleServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String fullName = request.getParameter("fullName");
        out.println("Hello doPost " + userName+ "we know your full name   "+ userName +"  "+ fullName  );
        String prof = request.getParameter("prof");
        out.println("your are a  "+prof);
//        String location = request.getParameter("location");
        String[] location = request.getParameterValues("location");
        out.println("you are at  "+location.length+" places  ");
        for (int i=0 ; i<location.length; i++){
            out.println(location[i]);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String fullName = request.getParameter("fullName");
        out.println("Hello doGet " + userName+ "we know your full name"+ fullName);
    }
}
