package cr.ac.tec.DataSaved.Profiles;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.Company.Company;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;

import java.util.ArrayList;

public class ProfileUser extends ProfileStructure {

   private ArrayList<Company> companies;

   public ProfileUser(MyMenu myMenu){
       this.myMenu=myMenu;
       this.companies=new ArrayList<>();
   }
   public void AddCompany(String name, double init, double end,String[] days,User... user){
       Company company=new Company(name,init,end,days);
       company.addMember(user);
   }



}
