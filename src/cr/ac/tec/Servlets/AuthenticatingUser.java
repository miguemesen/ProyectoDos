package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.DataSaved.InfoTree.UserTree;
import cr.ac.tec.MD5.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/logs",name = "SoloPruebasd")
public class AuthenticatingUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        resp.setContentType("application/json");
                        String toReturn;
                        PrintWriter printWriter = resp.getWriter();
                        UserTree userTree = UserTree.getInstance();
                        String name = req.getParameter("UserName");
                        String password = req.getParameter("Password");
                        password = MD5.getMD5(password);
                        String result = TreeConsultant.getUser(name, password);
                        printWriter.print(result);
                    } catch (Exception e) {
                    }

                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.run();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
