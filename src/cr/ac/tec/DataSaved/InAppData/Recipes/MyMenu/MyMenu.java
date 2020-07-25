package cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu;

import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;

import java.util.ArrayList;

public class MyMenu {
    private ArrayList<Integer> Recipes;
    public MyMenu(){
        Recipes=new ArrayList<>();
    }
    public void add(Recipe recipe){
        if(recipe==null)return;
        if(Recipes.contains(recipe))return;
        Recipes.add(recipe.getID());
    }
    public void delete(Recipe recipe){
        if(recipe==null)return;
        if(!Recipes.contains(recipe))return;
        Recipes.remove(recipe.getID());
    }
    public ArrayList<Recipe> getRecipes(){
        return TreeConsultant.getRecipesFromID(Recipes);
    }
    public void setRecipes(ArrayList<Recipe> recipes){
        if(recipes==null)return;
        this.Recipes=new ArrayList<>();
        for (int i=0;i<recipes.size();i++){
            this.Recipes.add(recipes.get(i).getID());
        }
    }

    @Override
    public String toString() {
        String res="";
        for(int i=0;i<Recipes.size();i++){
            res+=Integer.toString(Recipes.get(i));
        }
        return res;
    }
}
