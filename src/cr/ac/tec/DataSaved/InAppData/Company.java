package cr.ac.tec.DataSaved.InAppData;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;

import java.util.ArrayList;

public class Company extends RecipeOwners {
    private String CompanyName;
    private  ArrayList<User> members;
    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(!(o instanceof Company))return 1;
        Company company=(Company)o;
        return this.CompanyName.compareTo(company.CompanyName);
    }

    @Override
    public ArrayList<User> getOwner() {
        return members;
    }
}
