package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.InAppData.Recipes.Difficulty;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.RecipeTree;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.DataSaved.InfoTree.UserTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RecipeForm",value = "/RecipeGetter")
public class RecipeForm extends HttpServlet {
    private String Author="Author";
    private String RecipeName="RecipeName";
    private String RecipeRoll="RecipeRoll";
    private String RecipeKind="RecipeKind";
    private String RecipeTime="RecipeTime";
    private String DietType="DietType";
    private String divisor="/";
    private String portions="portions";
    private String Steps="Steps";
    private String Ingredients="Ingredients";
    private String Amount="Amount";
    private String Difficulty="Difficulty";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserName=req.getParameter(this.Author);
        String RecipeName=req.getParameter(this.RecipeName);
        String RecipeKind=req.getParameter(this.RecipeKind);
        String RecipeRoll=req.getParameter(this.RecipeRoll);
        String RecipeTime=req.getParameter(this.RecipeTime);
        String dietTypes=req.getParameter(this.DietType);
        int Portion=Integer.parseInt(req.getParameter(portions));
        String[] DietTypes=dietTypes.split(divisor);

        for(int i=0;i<DietTypes.length;i++){

            System.out.println("Slau2:"+DietTypes[i]);
        }
        String steps=req.getParameter(this.Steps);
        String[] Steps=steps.split(this.divisor);
        String ingredients=req.getParameter(this.Ingredients);
        String[] Ingredients=ingredients.split(this.divisor);
        int amount=Integer.parseInt(req.getParameter(this.Amount));
        int difficulty=Integer.parseInt(req.getParameter(this.Difficulty));

        Recipe recipe=new Recipe();
        recipe.build(recipe.new builder()
                .setSteps(Steps)
                .setIngredientList(Ingredients)
                .setRecipeKind(RecipeKind)
                .setAmount(amount)
                .setRecipeRoll(RecipeRoll)
                .setRecipeTime(RecipeTime)
                .setDietType(DietTypes)
                .setRecipeName(RecipeName)
                .setRecipeName(RecipeName)
                .setDifficulty(difficulty)
                .setAuthor(UserName)
                .setPortions(Portion)
        );
        TreeConsultant.RecipeOwner(UserName).addRecipe(recipe);
        RecipeTree recipeTree=new RecipeTree();
        recipeTree.attach(recipe);
        UserTree.getInstance().updateFile();

    }
}
