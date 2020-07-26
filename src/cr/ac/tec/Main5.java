package cr.ac.tec;

import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.Random.Random;

import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) {
        ArrayList<Recipe> recipeArrayList=TreeConsultant.getRecipe("tra");
        for(int i=0;i<recipeArrayList.size();i++){
            System.out.println(recipeArrayList.get(i));
        }
    }
}
