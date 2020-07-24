package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InfoTree.UserTree;
import cr.ac.tec.Files.JsonExchange;
import cr.ac.tec.MD5.MD5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value ="/logs",name = "Authenticate")
public class AuthenticateUser extends HttpServlet {
    private final String UserName="UserName";
    private final String Password="Password";
    private final String DMT="";
    private final int NO=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("application/json");
        String toReturn;
        PrintWriter printWriter=response.getWriter();
        UserTree userTree= UserTree.getInstance();
        String name=request.getParameter(UserName);
        String password= request.getParameter(Password);
        password= MD5.getMD5(password);
        User user =new User(name,password,DMT,DMT,NO);// the age , first name and last name doesnt matter here
        User user2 =userTree.getMember(user);
        RequestDispatcher requestDispatcher;
        if(!user.equals(user2)){
            //the login fails here
            //requestDispatcher=request.getRequestDispatcher("/Pages/LoginPage/Login.jsp");
            toReturn="";

        }
        else {
            //this login is correct
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            HttpSession session=request.getSession();
            session.setAttribute("logged", "True");
            toReturn= JsonExchange.getStringFromObject(user2);
            //requestDispatcher = request.getRequestDispatcher("/Pages/LoginPage/Logged.jsp");
        }
        //requestDispatcher.forward(request,response);
        printWriter.print(toReturn);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
