package cr.ac.tec.DataSaved.Interfaces;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;

import java.util.ArrayList;

public abstract class RecipeOwners implements Comparable {
    protected MyMenu myMenu;
    public abstract ArrayList<User> getOwner();

}
