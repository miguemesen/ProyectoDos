package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.Client;
import cr.ac.tec.DataSaved.ClientLogin.UserTree;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet(value = "/register", name = "Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("UserName");
        String pass=req.getParameter("Password");
        UserTree userTree=UserTree.getInstance();
        Client client =new Client(name,pass);
        RequestDispatcher requestDispatcher;
        if(userTree.attach(client)){
            requestDispatcher=req.getRequestDispatcher("/Pages/LoginPage/Login.jsp");
        }
        else {
            System.out.println("registro fallado");
            requestDispatcher=req.getRequestDispatcher("/Pages/LoginPage/SignIn.jsp");
        }
        requestDispatcher.forward(req,resp);
    }
}
