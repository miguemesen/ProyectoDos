package cr.ac.tec.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/NewsFed", name = "NewsFed")
public class NewsFed extends HttpServlet {
    private String UserNames="UserName";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        String UserName=req.getParameter(UserNames);
                        resp.getWriter().print(cr.ac.tec.DataSaved.NewsFed.NewsFed.getNewsFed(UserName));
                        System.out.println(cr.ac.tec.DataSaved.NewsFed.NewsFed.getNewsFed(UserName));
                    }
                    catch (Exception e){}
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
