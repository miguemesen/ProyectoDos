package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.ClientLogin.UserTree;
import cr.ac.tec.MD5.MD5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(value ="/logs",name = "Authenticate")
public class AuthenticateUser extends HttpServlet {
    private final String UserName="UserName";
    private final String Password="Password";
    private final String DMT="";
    private final int NO=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserTree userTree= UserTree.getInstance();
        String name=request.getParameter(UserName);
        String password= request.getParameter(Password);
        password= MD5.getMD5(password);
        User user =new User(name,password,DMT,DMT,NO);// the age , first name and last name doesnt matter here
        User user2 =userTree.getUser(user);
        RequestDispatcher requestDispatcher;
        if(!user.equals(user2)){
            //the login fails here
            requestDispatcher=request.getRequestDispatcher("/Pages/LoginPage/Login.jsp");
        }
        else {
            //this login is correct
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            HttpSession session=request.getSession();
            session.setAttribute("logged", "True");
           // Cookie ck=new Cookie("userName",name);
            //response.addCookie(ck);
            requestDispatcher = request.getRequestDispatcher("/Pages/LoginPage/Logged.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
