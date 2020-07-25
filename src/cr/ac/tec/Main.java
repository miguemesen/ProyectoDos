package cr.ac.tec;

import cr.ac.tec.DataSaved.InAppData.Recipes.Difficulty;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Sorting.RadixSort;

public class Main {
    public static void main(String[] args) {
        Recipe recipe=new Recipe();
        recipe.build(recipe.new builder().setAmount(12).setAuthor("My culito").setDietType("Celiac").setDifficulty(new Difficulty(44))
                .setIngredientList("Zanahoria").setPortions(11).setSteps("pata patata").setRecipeKind("Brunch").setRecipeName("Carne")
                .setRecipeRoll("Entry").setRecipeTime("ShortTime"));
        recipe.setScore(90);
        recipe.setComparingState(3);
        Recipe recipe1=new Recipe();
        recipe1.build(recipe1.new builder().setAmount(11).setAuthor("La perra").setDietType("Celiac").setDifficulty(new Difficulty(45))
                .setIngredientList("Steak","Soup").setPortions(2).setSteps("El pato").setRecipeKind("Brunch").setRecipeName("Vino")
                .setRecipeRoll("Entry").setRecipeTime("ShortTime"));
        recipe1.setScore(40);
        recipe1.setComparingState(3);


        Recipe recipe2=new Recipe();
        recipe2.build(recipe2.new builder().setAmount(11).setAuthor("La perra").setDietType("Celiac").setDifficulty(new Difficulty(1))
                .setIngredientList("Steak","Soup").setPortions(2).setSteps("El pato").setRecipeKind("Brunch").setRecipeName("Conac")
                .setRecipeRoll("Entry").setRecipeTime("ShortTime"));
        recipe2.setScore(40);
        recipe2.setComparingState(3);

        DoubleList<Recipe>List=new DoubleList<>();
        List.AddTail(recipe);
        List.AddTail(recipe1);
        List.AddTail(recipe2);
        RadixSort<Recipe> sort=new RadixSort<>();
        sort.setList(List);
        sort.sort();
        for(int i=0;i<List.getLength();i++){
            System.out.println(List.get(i));
        }


    }
}
