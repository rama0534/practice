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
        String UserName = request.getParameter("UserName");
        out.println("Hello from doPost method " + UserName);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String UserName = request.getParameter("UserName");
        out.println("Hello doGet " + UserName);
    }
}
