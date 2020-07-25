package cr.ac.tec.DataSaved.Profiles;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.Company.Company;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;

import java.util.ArrayList;

public class ProfileUser extends ProfileStructure {

   private ArrayList<String> companies;

   public ProfileUser(MyMenu myMenu){
       this.myMenu=myMenu;
       this.companies=new ArrayList<>();
   }

   public void AddCompany(Company company){
       if(company==null)return;
       companies.add(company.toString());

   }



}
