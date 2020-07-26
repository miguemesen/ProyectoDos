package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.Files.JsonExchange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Browser",value = "/browser")
public class getSearch extends HttpServlet {
    private final String Chef="Chef";
    private final String User="User";
    private final String Company="Company";
    private final String Recipe="Recipe";
    private final String via="via";
    private final String Keyword="Keyword";
    private final String Tags="Tags";
    private final String divider="/";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String source=req.getParameter(via);
        String text=req.getParameter(Keyword);
        String tags=req.getParameter(Tags);
        String[] TheTags=tags.split(divider);
        resp.getWriter().print(getReturn(via,text,TheTags));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    private String getReturn(String via,String text,String... tags){
        if(via==null)return "";
        switch (via){
            case Recipe:
                return JsonExchange.getStringFromObject(TreeConsultant.getRecipe(text,tags));
            case Company:
                return JsonExchange.getStringFromObject(TreeConsultant.getCompanies(text));
            case User:
                return JsonExchange.getStringFromObject(TreeConsultant.FindUser(text));
            case Chef:
                return JsonExchange.getStringFromObject(TreeConsultant.FindChef(text));
            default:
                return "";
        }
    }
}
