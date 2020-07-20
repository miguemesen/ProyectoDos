package cr.ac.tec.TextMatching;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.Difficulty;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenuManager;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        Recipe recipe=new Recipe();
       Recipe.builder builder=recipe.new builder().setRecipeTime("LongerTime").setRecipeRoll("Appetizer").setDietType("Celiac").setRecipeName("Estofado").setPortions(12).setAuthor("Carla").setDifficulty(new Difficulty(22)).setAmount(1200).setRecipeKind("Breakfast").setIngredientList("").setSteps("");
       recipe.build(builder);
       recipe.setScore(56);
       try {
         //  Thread.sleep(5000);
       }
       catch (Exception e){}

       Recipe recipe1=new Recipe();
       Recipe.builder builder1=recipe1.new builder().setRecipeTime("LongTime").setRecipeRoll("Entry").setDietType("Vegetarian").setRecipeName("Salad").setPortions(54).setAuthor("Luis").setDifficulty(new Difficulty(88)).setAmount(5000).setRecipeKind("Lunch").setIngredientList("").setSteps("");
       recipe1.build(builder1);
       recipe1.setScore(44);
        Recipe recipe2=new Recipe();
        Recipe.builder builder2=recipe2.new builder().setRecipeTime("MiddleTime").setRecipeRoll("MainCourse").setDietType("Keto").setRecipeName("Carne").setPortions(9).setAuthor("Geli").setDifficulty(new Difficulty(65)).setAmount(3500).setRecipeKind("Dinner").setIngredientList("").setSteps("");
        recipe2.build(builder2);
        recipe2.setScore(30);
        Recipe recipe3=new Recipe();
        Recipe.builder builder3=recipe3.new builder().setRecipeTime("ShortTime").setRecipeRoll("Alcoholic").setDietType("Kosher").setRecipeName("Wine").setPortions(11).setAuthor("Maria").setDifficulty(new Difficulty(98)).setAmount(2000).setRecipeKind("Snack").setIngredientList("").setSteps("");
        recipe3.build(builder3);
        recipe3.setScore(90);
        ArrayList<Recipe> recipes=new ArrayList<>();
        recipes.add(recipe);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        User user=new User("Pedro","Carlos","","",123);
        user.setRecipe(recipes);
       MyMenuManager.sortByDate(user);
        recipes=user.getMyMenu().getRecipes();
        for(int i=0;i<recipes.size();i++){
            System.out.println(recipes.get(i));
        }

    }
}
