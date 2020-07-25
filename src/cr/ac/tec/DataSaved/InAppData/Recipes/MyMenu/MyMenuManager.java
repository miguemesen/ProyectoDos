package cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;
import cr.ac.tec.DataStructures.LinkedList.Sorting.*;
import java.util.ArrayList;
public class MyMenuManager {
    final static int ID=0;
    final static int Date=1;
    final static int Score=2;
    final static int Difficulty=3;
    private final static LinkedListTool<Recipe> recipeManager=new LinkedListTool<>();
    private final static QuickSort<Recipe> QUICK_SORT=new QuickSort<>();
    private final static InsertionDouble<Recipe> Insertion_Sort=new InsertionDouble<>();
    private final static BubbleSortDouble<Recipe> Bubble_Sort= new BubbleSortDouble<>();
   private final static RadixSort<Recipe> RADIX_SORT=new RadixSort();
    public static void sortByDate(RecipeOwners user){
        DoubleList<Recipe> recipe=Verification(user);
        for (int i=0;i<recipe.getLength();i++){
            System.out.println(recipe.get(i).toString());
        }
        setComparingState(Date,recipe);
        if(recipe==null)return;
        user.setRecipe(getSortedMyMenu(recipe,Bubble_Sort));
        setComparingState(ID,recipe);
    }

    public static void sortByScore(RecipeOwners user){
        DoubleList<Recipe> recipe=Verification(user);
        setComparingState(Score,recipe);
        if(recipe==null)return;
        user.setRecipe(getSortedMyMenu(recipe,QUICK_SORT));
        setComparingState(ID,recipe);

    }
    public static void sortByDifficulty(RecipeOwners user){
        DoubleList<Recipe> rec=Verification(user);
        setComparingState(Difficulty,rec);
        if(rec==null)return;
        user.setRecipe(getSortedMyMenu(rec,RADIX_SORT));
        setComparingState(ID,rec);

    }
    public static void sorting(RecipeOwners user,int ComparingState){
        DoubleList<Recipe> recipe=Verification(user);
        if(recipe==null || recipe.getLength()<=1)return;
        setComparingState(ComparingState,recipe);
        Sorting<Recipe> sorting;
        switch (ComparingState){
            case Score:
                sorting=QUICK_SORT;
                break;
            case Date:
                sorting=Bubble_Sort;
                break;
            case Difficulty:
                sorting=RADIX_SORT;
                break;
            default:
                sorting=Insertion_Sort;
                break;
        }
        user.setRecipe(getSortedMyMenu(recipe,sorting));
        setComparingState(ID,recipe);
    }
    public static DoubleList<Recipe> Verification(RecipeOwners user){
        if(user==null)return null;
        return transformation(user.getMyMenu().getRecipes());
    }
    public  static DoubleList<Recipe> transformation(ArrayList<Recipe> recipes){
        return recipeManager.tDoubleList(recipes);
    }
    public  static ArrayList<Recipe> getSortedMyMenu(DoubleList<Recipe> myMenu, Sorting<Recipe> sorting){
        if(myMenu==null || sorting==null)return null;
        sorting.setList(myMenu);
        sorting.sort();
        return recipeManager.toJavaList(myMenu);
    }
    public  static void setComparingState(int state,DoubleList<Recipe> myMenu){
        if(myMenu==null)return;
        for(int i=0;i<myMenu.getLength();i++){
            myMenu.get(i).setComparingState(state);
        }
    }
}
