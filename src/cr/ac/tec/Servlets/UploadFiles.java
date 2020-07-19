package cr.ac.tec.Servlets;


import com.oreilly.servlet.MultipartRequest;
import cr.ac.tec.Files.PlainText;
import cr.ac.tec.Random.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Upload",value = "/Upload")
public class UploadFiles extends HttpServlet {
    private final static String recipe="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\COOKTIMEProyect\\web\\Resources\\Recipes";
    private final static String profileImage ="/Resources/Profile/User";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MultipartRequest mrequest = new MultipartRequest(req, recipe);
       Enumeration enumeration= mrequest.getFileNames();
       while (enumeration.hasMoreElements())      {
           String fileName=(String)enumeration.nextElement();
           File file=mrequest.getFile(fileName);
           file.renameTo(new File(recipe+"\\"+"FareWall.png"));
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
