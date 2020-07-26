package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenuManager;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.UserTree;
import cr.ac.tec.Files.JsonExchange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "MyMenu",value = "/MyMenu")
public class MyMenuServlet extends HttpServlet {
    private static final int ScoreState=1;
    private static final int DateState=2;
    private static final int DifficultyState=3;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        PrintWriter writer = resp.getWriter();
                        int sortState = Integer.parseInt(req.getParameter("SortState"));
                        String UserName = req.getParameter("UserName");
                        User user = UserTree.getInstance().getMember(new User(UserName));
                        MyMenuManager.sorting(user, sortState);
                        MyMenu myMenu = user.getMyMenu();
                        ArrayList<Recipe> arrayList = myMenu.getRecipes();
                        String send = JsonExchange.getStringFromObject(arrayList);
                        writer.print(send);

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
