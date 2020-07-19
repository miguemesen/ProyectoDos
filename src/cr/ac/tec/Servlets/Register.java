package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.ClientLogin.UserTree;
import cr.ac.tec.MD5.MD5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(value = "/register", name = "Register")
public class Register extends HttpServlet {
    private static final String UserName="UserName";
    private static final String Password="Password";
    private static final String firstName="FirstName";
    private static final String lastName="LastName";
    private static final String Age="Age";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter(UserName);
        String pass=req.getParameter(Password);
        pass= MD5.getMD5(pass);
        String FirstName=req.getParameter(firstName);
        String LastName=req.getParameter(lastName);
        int age=Integer.parseInt(req.getParameter(Age));
        UserTree userTree=UserTree.getInstance();
        User user =new User(userName,pass,FirstName,LastName,age);
        RequestDispatcher requestDispatcher;
        if(userTree.attach(user)){
            requestDispatcher=req.getRequestDispatcher("/Pages/LoginPage/Login.jsp");
        }
        else {
            System.out.println("register failed");
            requestDispatcher=req.getRequestDispatcher("/Pages/LoginPage/SignIn.jsp");
        }
        requestDispatcher.forward(req,resp);
    }
}
