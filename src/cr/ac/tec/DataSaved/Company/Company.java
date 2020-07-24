package cr.ac.tec.DataSaved.Company;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import cr.ac.tec.DataSaved.Profiles.ProfileCompany;

import java.util.ArrayList;
import java.util.Objects;

public class Company extends RecipeOwners {
    private ProfileCompany profileCompany;
    private String CompanyName;// it unique
    private Schedule schedule;
    private  ArrayList<User> Members;
    public Company(String name, double Init, double End,String... days){
        this.CompanyName=name;
        Schedule.Builder builder=new Schedule.Builder();
        builder.AddDays(days);
        builder.End(End);
        builder.Init(Init);
        this.schedule=new Schedule(builder);
        this.profileCompany=new ProfileCompany(new MyMenu());
        Members= new ArrayList<>();
    }
    public Company(String name){
        this.CompanyName=name;
    }
    public void addMember(User...users){
        if(users==null)return;
        for(int i=0;i<users.length;i++){
            Members.add(users[i]);
        }
    }
    public void addRecipe(Recipe recipe){
        profileCompany.addRecipe(recipe);
    }

    @Override
    public MyMenu getMyMenu() {
        return profileCompany.getMyMenu();
    }
    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(!(o instanceof Company))return 1;
        Company company=(Company)o;
        return this.CompanyName.compareTo(company.CompanyName);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(CompanyName, company.CompanyName) &&
                Objects.equals(Members, company.Members);
    }
    @Override
    public int hashCode() {
        return Objects.hash(CompanyName, Members);
    }
    @Override
    public String getIdentifier() {
        return  this.CompanyName;
    }
}
