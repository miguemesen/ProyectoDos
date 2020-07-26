package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InfoTree.UserTree;
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
        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        PrintWriter printWriter=resp.getWriter();
                        String userName=req.getParameter(UserName);
                        String pass=req.getParameter(Password);
                        pass= MD5.getMD5(pass);
                        String FirstName=req.getParameter(firstName);
                        String LastName=req.getParameter(lastName);
                        int age=Integer.parseInt(req.getParameter(Age));
                        UserTree userTree=UserTree.getInstance();
                        User user =new User(userName,pass,FirstName,LastName,age);
                        if(userTree.attach(user)){
                            printWriter.print(true);
                            return;
                        }
                        printWriter.print(false);

                    }
                    catch (Exception e){}
                }

            }
        };
        Thread thread=new Thread(runnable);
        thread.run();


    }
}
