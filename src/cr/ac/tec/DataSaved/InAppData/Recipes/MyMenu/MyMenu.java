package cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu;

import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;

import java.util.ArrayList;

public class MyMenu {
    //private RecipeOwners owners;
    private ArrayList<Recipe> Recipes;
    public MyMenu(RecipeOwners owners){
        //this.owners=owners;
        Recipes=new ArrayList<>();
    }

    public void add(Recipe recipe){
        if(recipe==null)return;
        if(Recipes.contains(recipe))return;
        Recipes.add(recipe);
    }
    public ArrayList<Recipe> getRecipes(){
        return Recipes;
    }
}
