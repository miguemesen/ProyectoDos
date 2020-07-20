package cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;
import cr.ac.tec.DataStructures.LinkedList.Sorting.*;

import java.util.ArrayList;
public class MyMenuManager {
    private final static LinkedListTool<Recipe> recipeManager=new LinkedListTool<>();
    private final static QuickSort<Recipe> QUICK_SORT=new QuickSort<>();
    private final static InsertionDouble<Recipe> Insertion_Sort=new InsertionDouble<>();
    private final static BubbleSortDouble<Recipe> Bubble_Sort= new BubbleSortDouble<>();
   // private final static RadixSort<Recipe> RADIX_SORT=new RadixSort();
    public static void sortByDate(User user){
        DoubleList<Recipe> recipe=Verification(user);
        setComparingState(1,recipe);
        if(recipe==null)return;
        user.setRecipe(getSortedMyMenu(recipe,Bubble_Sort));
        setComparingState(0,recipe);
    }
    public static void sortByScore(User user){
        DoubleList<Recipe> recipe=Verification(user);
        setComparingState(2,recipe);
        if(recipe==null)return;
        user.setRecipe(getSortedMyMenu(recipe,QUICK_SORT));
        setComparingState(0,recipe);

    }
    public static void sortByDifficulty(User user){
        //falta radix sort

    }
    public static DoubleList<Recipe> Verification(User user){
        if(user==null)return null;
        return transformation(user.getMyMenu().getRecipes());
    }
    public  static DoubleList<Recipe> transformation(ArrayList<Recipe> recipes){
        return recipeManager.tDoubleList(recipes);
    }
    private static ArrayList<Recipe> getSortedMyMenu(DoubleList<Recipe> myMenu, Sorting<Recipe> sorting){
        if(myMenu==null || sorting==null)return null;
        sorting.setList(myMenu);
        sorting.sort();
        return recipeManager.toJavaList(myMenu);
    }
    private static void setComparingState(int state,DoubleList<Recipe> myMenu){
        if(myMenu==null)return;
        for(int i=0;i<myMenu.getLength();i++){
            myMenu.get(i).setComparingState(state);
        }
    }
}
