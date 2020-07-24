package cr.ac.tec.DataSaved.NewsFed;

import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import cr.ac.tec.Files.JsonExchange;


import java.util.ArrayList;

public class NewsFed {
    public static String getNewsFed(String userName){
        RecipeOwners recipeOwners=TreeConsultant.RecipeOwner(userName);
        ArrayList<Recipe> recipes=TreeConsultant.getSuggestions(recipeOwners);
        String result=JsonExchange.getStringFromObject(recipes);
        if(result==null)return "";
        return  result;
    }
}
