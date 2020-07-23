package cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu;

import com.google.gson.annotations.Expose;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;

import java.util.ArrayList;

public class MyMenu {
    private ArrayList<Recipe> Recipes;
    public MyMenu(){
        Recipes=new ArrayList<>();
    }
    public void add(Recipe recipe){
        if(recipe==null)return;
        if(Recipes.contains(recipe))return;
        Recipes.add(recipe);
    }
    public void delete(Recipe recipe){
        if(recipe==null)return;
        if(!Recipes.contains(recipe))return;
        Recipes.remove(recipe);
    }
    public ArrayList<Recipe> getRecipes(){
        return Recipes;
    }
}
