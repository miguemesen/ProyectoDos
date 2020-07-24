package cr.ac.tec;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.DataSaved.InfoTree.UserTree;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import cr.ac.tec.DataStructures.ArrayList.ArrayTools;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

import java.util.ArrayList;



public class Main7 {
    public static void main(String[] args) {
        RecipeOwners recipeOwners =TreeConsultant.RecipeOwner("Nicole");
        System.out.println(recipeOwners);
        User user=(User)recipeOwners;
       ArrayList<String> arrayList= user.getFollows();
       for(int i=0;i<arrayList.size();i++){
           System.out.println(arrayList.get(i));
       }

       ArrayList<Recipe> recipes= TreeConsultant.getSuggestions(recipeOwners);
       for(int i=0;i<recipes.size();i++){
           System.out.println(recipes.get(i));
       }
    }
}
