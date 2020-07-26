package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.Company.Company;
import cr.ac.tec.DataSaved.InfoTree.CompanyTree;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.DataSaved.InfoTree.UserTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/newWorker",name = "CompanyAdd")
public class AddUserToCompany  extends HttpServlet {
    private String CompanyName="CompanyName";
    private String UserName="UserName";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try{
                        String company=req.getParameter(CompanyName);
                        String UserN=req.getParameter(UserName);
                        Company myCompany=TreeConsultant.getCompanyFromName(company);
                        User myUser=TreeConsultant.getUserFromName(UserN);
                        myUser.AddCompany(myCompany);
                        myCompany.addMember(myUser);
                        CompanyTree.getInstance().updateFile();
                        UserTree.getInstance().updateFile();

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
