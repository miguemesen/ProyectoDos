package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.User;
import cr.ac.tec.DataSaved.UserTree;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value ="/logs",name = "logCase")
public class LoginCase extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserTree userTree= UserTree.getInstance();
        String name=request.getParameter("UserName");
        String password= request.getParameter("Password");
        request.setAttribute("name",name);
        request.setAttribute("password",password);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Pages/LoginPage/Logged.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
