package cr.ac.tec;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.Difficulty;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenuManager;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.RecipeTree;
import cr.ac.tec.DataSaved.InfoTree.UserTree;
import cr.ac.tec.Files.JsonExchange;

public class Main6 {
    public static void main(String[] args) {
        User user=new User("Carl","Satanas","MyName","Soy un perra",66);
        User user1=new User("Bob","patoconpatas","patito21","redaccion tecnica",11);
        user.AddFollower(user1);
        Recipe recipe=new Recipe();
       recipe.build(recipe.new builder().setAmount(12).setAuthor("My culito").setDietType("Celiac").setDifficulty(new Difficulty(44))
                .setIngredientList("Zanahoria").setPortions(11).setSteps("pata patata").setRecipeKind("Brunch").setRecipeName("Carne")
                .setRecipeRoll("Entry").setRecipeTime("ShortTime"));
       recipe.setScore(90);
       user.addRecipe(recipe);
       recipe.abbObserver(user);
       try {
           Thread.sleep(5000);
       }catch (Exception e){}

       Recipe recipe1=new Recipe();
       recipe1.build(recipe1.new builder().setAmount(11).setAuthor("La perra").setDietType("Celiac").setDifficulty(new Difficulty(33))
               .setIngredientList("Steak","Soup").setPortions(2).setSteps("El pato").setRecipeKind("Brunch").setRecipeName("Vino")
               .setRecipeRoll("Entry").setRecipeTime("ShortTime"));
       recipe1.setScore(40);
       user.addRecipe(recipe1);
        RecipeTree recipeTree=RecipeTree.getInstance();
        recipeTree.attach(recipe);
        recipeTree.attach(recipe1);
        UserTree userTree=UserTree.getInstance();
        userTree.attach(user);
        userTree.attach(user1);

    }
}
