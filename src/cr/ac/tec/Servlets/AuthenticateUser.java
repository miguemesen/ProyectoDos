package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.Client;
import cr.ac.tec.DataSaved.ClientLogin.UserTree;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(value ="/logs",name = "Authenticate")
public class AuthenticateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserTree userTree= UserTree.getInstance();
        String name=request.getParameter("UserName");
        String password= request.getParameter("Password");
        Client client =new Client(name,password);
        Client client2 =userTree.getUser(client);
        RequestDispatcher requestDispatcher;
        if(!client.equals(client2)){
            requestDispatcher=request.getRequestDispatcher("/Pages/LoginPage/Login.jsp");
        }
        else {
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            HttpSession session=request.getSession();
            session.setAttribute("User",client2);
            Cookie ck=new Cookie("userName",name);
            response.addCookie(ck);
            requestDispatcher = request.getRequestDispatcher("/Pages/LoginPage/Logged.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
