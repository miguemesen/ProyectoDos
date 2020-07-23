package cr.ac.tec.DataSaved.Profiles;

import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;

public abstract class ProfileStructure {
    protected  String imageRoute;
    protected MyMenu myMenu;
    public MyMenu getMyMenu(){
        return myMenu;
    }
    public void deleteFromMyMenu(Recipe recipe){
        myMenu.delete(recipe);
    }
    public void addRecipe(Recipe recipe){
        myMenu.add(recipe);
    }


}
