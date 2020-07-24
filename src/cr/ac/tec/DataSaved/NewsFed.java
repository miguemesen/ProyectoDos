package cr.ac.tec.DataSaved;

import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;

import java.util.ArrayList;

public class NewsFed {
    public static String getNewsFed(String userName){
        RecipeOwners recipeOwners=TreeConsultant.RecipeOwner(userName);
        ArrayList<String> recipes=recipeOwners.getFollows();

        return "";
    }
}
