package cr.ac.tec.Servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/log",name = "LoginPage")
public class Login extends HttpServlet {
    private String Name;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // request.getCookies()
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Pages/LoginPage/Login.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
