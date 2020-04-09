package ramasadam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "newSimpleServlet", urlPatterns = "/first")
public class NewSimpleServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,
            IOException {
        PrintWriter writer = response.getWriter();
        writer.write("This is POST");
        writer.flush();
        writer.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,
            IOException {
        System.out.println("do get");
        response.getWriter().write("Testing");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
