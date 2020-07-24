package cr.ac.tec;

import com.google.gson.Gson;
import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.*;
import cr.ac.tec.Files.JsonExchange;

import java.io.FileWriter;

public class Main2 {
    public static void main(String[] args){
        Recipe recipe=new Recipe();
        Recipe.builder builder=recipe.new builder().setRecipeKind("Lunch").setDietType("Vegetarian").setRecipeName("Rice and beans").setAuthor("TitoDiaz").setIngredientList("beans","rice","steak").setAmount(44).setDifficulty(new Difficulty(50)).setPortions(4).setRecipeRoll("WarmDrink").setRecipeTime("LongTime").setSteps("Bata los huevos");
        recipe.build(builder);
        User user =new User("Eduardo","BokuNoPico","","",85);
        user.addRecipe(recipe);
        Gson gson=new Gson();
        User user1=new User("Nicole",":v","","",45);
        user.AddFollows(user1);
        User[] users=new User[2];
        users[0]=user;
        users[1]=user1;
        String printing=gson.toJson(users);
       // System.out.println(printing);

        String recipeStringJson=gson.toJson(recipe);
       // System.out.println(recipeStringJson);
        try {
            FileWriter fileWriter=new FileWriter("resources/segunda.json");
            fileWriter.write(printing);
            fileWriter.flush();
        }
        catch (Exception e){}

        Recipe recipe1=(Recipe) JsonExchange.getObjectFromJson("pruebas.json",Recipe.class);
       // System.out.println(recipe.stringing());

    }
}
