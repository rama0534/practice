import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.rama.User;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String userId, password;

      userId =  request.getParameter("userId");
      password = request.getParameter("password");

      loginService loginService = new loginService();
      boolean result = loginService.authenticate(userId, password);

      if (result){
          User user = loginService.getUserDetails(userId);
          request.setAttribute("user", user);
          RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
//          response.sendRedirect("success.jsp");
          dispatcher.forward(request, response);
          return;
      }
      else {
          response.sendRedirect("login.jsp");
          return;
      }


    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
