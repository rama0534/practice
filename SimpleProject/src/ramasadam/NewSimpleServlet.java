package ramasadam;

import org.omg.IOP.ServiceContext;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@WebServlet(name = "newSimpleServlet", urlPatterns = "/NewSimpleServletPaths")

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
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        if(userName != "" && userName != null){
            session.setAttribute("savedUserName", userName);
            context.setAttribute("savedUserName", userName);
        }
        out.println("Request parameter has username as "+ userName);
        out.println("Session parameter has user name as "+ (String) session.getAttribute("savedUserName"));
        out.println("Context parameter has user name as "+ (String) context.getAttribute("savedUserName"));
        this.getServletConfig().getInitParameter("defaultUser");

//        String fullName = request.getParameter("fullName");
//        out.println("Hello doGet " + userName+ "we know your full name"+ fullName);
    }
}
