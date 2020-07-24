package cr.ac.tec.Servlets;

import cr.ac.tec.DataSaved.InAppData.Recipes.Difficulty;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.InfoTree.RecipeTree;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RecipeForm",value = "/register")
public class RecipeForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserName=req.getParameter("Author");
        String RecipeName=req.getParameter("RecipeName");
        String RecipeKind=req.getParameter("RecipeKind");
        String RecipeRoll=req.getParameter("RecipeRoll");
        String RecipeTime=req.getParameter("RecipeTime");
        String[] DietTypes=req.getParameterValues("DietType");
        String[] Steps=req.getParameterValues("Steps");
        String[] Ingredients=req.getParameterValues("Ingredients");
        int amount=Integer.parseInt(req.getParameter("Amount"));
        int difficulty=Integer.parseInt(req.getParameter("Difficulty"));
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
                .setDifficulty(new Difficulty(difficulty))
                .setAuthor(UserName)
        );
        TreeConsultant.RecipeOwner(UserName).addRecipe(recipe);
        RecipeTree recipeTree=new RecipeTree();
        recipeTree.attach(recipe);

    }
}
