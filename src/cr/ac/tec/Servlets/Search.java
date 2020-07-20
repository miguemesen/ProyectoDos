package cr.ac.tec.Servlets;

import cr.ac.tec.Files.PlainText;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(value = "/search")
public class Search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("application/json");
        String string=req.getReader().lines().collect(Collectors.joining());
        PlainText.writeFile("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\COOKTIMEProyect\\testing.json",string);
        resp.getWriter().println(string);
        //Lack to normalize the file
    }
}
