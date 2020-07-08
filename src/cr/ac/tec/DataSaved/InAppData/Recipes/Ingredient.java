package cr.ac.tec.DataSaved.InAppData.Recipes;

import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.DietType;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

public class Ingredient {
   private String Name;
    private DoubleList<DietType> DietAvailable;
    public Ingredient(String Name,DietType...diet){
        this.Name=Name;
        this.DietAvailable=new DoubleList<>();
        if(diet==null)return;
        for(int i=0;i<diet.length;i++){
            this.DietAvailable.AddTail(diet[i]);
        }

    }
}
