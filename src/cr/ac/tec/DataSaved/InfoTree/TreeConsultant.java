package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.Chef.Chef;
import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.Company.Company;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenuManager;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import cr.ac.tec.DataStructures.ArrayList.ArrayTools;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Sorting.InsertionDouble;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TreeConsultant {
    private static int suggestionMin=15;
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
            MyMenuManager.sortByDate(recipeOwner);
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
        ArrayList<Recipe> recipes= getRecipeList(recipeOwners.getFollows());
        if(recipes==null)recipes=new ArrayList<>();
        if(recipes.size()<=suggestionMin){
            appendTreeSuggestion(recipes,suggestionMin-recipes.size());
        }
        return recipes;
    }
    public static void appendTreeSuggestion(ArrayList<Recipe> recipes, int lack){
        if(recipes==null)return;
        DoubleList<Recipe> recipeDoubleList=recipeTree.getList();
        MyMenuManager.setComparingState(1,recipeDoubleList);
        ArrayList<Recipe> arrayList=MyMenuManager.getSortedMyMenu(recipeDoubleList,new InsertionDouble<Recipe>());
        for(int i=0;i<recipeDoubleList.getLength() && lack>0;i++){
            recipes.add(arrayList.get(i));
            lack--;
        }

    }
    public static ArrayList<Recipe> getRecipesFromID(ArrayList<Integer> IDList){
        initializer();
        ArrayList<Recipe> recipes=new ArrayList<>();
        if(IDList==null)return recipes;
        Recipe temp;
        for(int i=0;i<IDList.size();i++){
            temp=getRecipesFromID(IDList.get(i));
            if(temp!=null){
                recipes.add(temp);
            }
        }
        return recipes;

    }
    public static Recipe getRecipesFromID(int ID){
        initializer();
        return recipeTree.getMember(new Recipe(ID));
    }






}
