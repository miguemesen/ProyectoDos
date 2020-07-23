package cr.ac.tec;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.Difficulty;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.Files.JsonExchange;

public class Main6 {
    public static void main(String[] args) {
        User user=new User("Carl","Satanas","MyName","Soy un perra",66);
        User user1=new User("Bob","patoconpatas","patito21","redaccion tecnica",11);
        user.AddFollower(user1);
        Recipe recipe=new Recipe();
       recipe.build(recipe.new builder().setAmount(12).setAuthor("My culito").setDietType("Celiac").setDifficulty(new Difficulty(44))
                .setIngredientList("Zanahoria").setPortions(11).setSteps("pata patata").setRecipeKind("Brunch").setRecipeName("Eduardo")
                .setRecipeRoll("Entry").setRecipeTime("ShortTime"));
       user.addRecipe(recipe);
       recipe.abbObserver(user);
        System.out.println( JsonExchange.getStringFromObject(user));
    }
}
