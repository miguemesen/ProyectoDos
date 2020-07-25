package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.Company.Company;
import cr.ac.tec.DataSaved.InfoTree.CompanyTree;
import cr.ac.tec.DataSaved.InfoTree.UserTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CompanyForm" , value = "/Company")
public class CompanyForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter=resp.getWriter();
        String CompanyName=req.getParameter("CompanyName");
        int IH=Integer.parseInt(req.getParameter("InitHour"));
        int IM=Integer.parseInt(req.getParameter("InitMinute"));
        int FH=Integer.parseInt(req.getParameter("FinalHour"));
        int FM=Integer.parseInt(req.getParameter("FinalMinute"));
        String User=req.getParameter("UserName");
        User user= UserTree.getInstance().getMember(new User(User));
        if(user!=null){
            Company company=new Company(CompanyName,IH,IM,FH,FM);
            CompanyTree companyTree=CompanyTree.getInstance();
            companyTree.attach(company);
            user.AddCompany(company);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


}
