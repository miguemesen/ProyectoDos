package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.Chef.Chef;
import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.Company.Company;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import cr.ac.tec.DataStructures.ArrayList.ArrayTools;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TreeConsultant {
    private static UserTree userTree;
    private static ChefTree chefTree;
    private static CompanyTree companyTree;
    private static RecipeTree recipeTree;

    public static void initializer(){
        if(userTree==null)userTree=UserTree.getInstance();
        if(chefTree==null)chefTree=ChefTree.getInstance();
        if(companyTree==null)companyTree=CompanyTree.getInstance();
        if(recipeTree==null)recipeTree=RecipeTree.getInstance();
    }
    public static String getUser(String UserName, String Password){
        initializer();
        if(UserName==null || Password==null || UserName.length()<=0 || Password.length()<=0)return "";
        initializer();
        User user= new User(UserName,Password);//
        if(userTree.fullCheck(user) || chefTree.fullCheck(Chef.getChef(user))){
            return UserName;
        }
        return "";
    }

    public static RecipeOwners RecipeOwner(String UserName) {
        initializer();
        if(userTree==null)return null;
        User user=new User(UserName,"");
        RecipeOwners temp;
        user=userTree.getMember(user);
        temp=userTree.getMember(user);
        if(temp==null){
            temp=chefTree.getMember(Chef.getChef(user));
        }
        if(temp==null){
            temp=companyTree.getMember(new Company(UserName));
        }
        return temp;

    }
    public static ArrayList<Recipe> getRecipeList(String UserName){
        RecipeOwners recipeOwner=RecipeOwner(UserName);
        if(recipeOwner!=null){
            return recipeOwner.getMyMenu().getRecipes();
        }
        return null;

    }
    public static ArrayList<Recipe> getRecipeList(ArrayList<String> UserNames){
        ArrayList<Recipe> recipes=new ArrayList<>();
        ArrayTools<Recipe> tools=new ArrayTools<>();
        for(int i=0;i<UserNames.size();i++){
            tools.append(recipes,getRecipeList(UserNames.get(i)));
        }
        return recipes;
    }
    public static ArrayList<Recipe> getSuggestions(RecipeOwners recipeOwners){
        if(recipeOwners==null)return null;
        return getRecipeList(recipeOwners.getFollows());

    }






}
