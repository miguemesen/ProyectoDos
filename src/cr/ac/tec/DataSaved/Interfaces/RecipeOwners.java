package cr.ac.tec.DataSaved.Interfaces;


import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;

import java.util.ArrayList;

public abstract class RecipeOwners implements Comparable {
    protected ArrayList<String> follows;
    protected ArrayList<String> followers;
    public abstract String getIdentifier();
    public abstract void addRecipe(Recipe recipe);
    public abstract MyMenu getMyMenu();

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public ArrayList<String> getFollows() {
        return follows;
    }

    public void AddFollower(RecipeOwners owners) {
        if(owners==null)return;
        if(!followers.contains(owners.toString())) {
            this.followers.add(owners.toString());
            owners.AddFollows(this);
        }
    }

    public void AddFollows(RecipeOwners owners) {
        if(owners==null)return;
        if(!follows.contains(owners.toString())) {
            this.follows.add(owners.toString());
            owners.AddFollower(this);
        }
    }

}
