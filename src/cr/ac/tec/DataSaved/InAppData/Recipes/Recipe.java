package cr.ac.tec.DataSaved.InAppData.Recipes;
import com.google.gson.annotations.Expose;
import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.DietType;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.RecipeKind;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.RecipeRoll;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.RecipeTime;
import cr.ac.tec.DataSaved.InAppData.Tags.Tagged;
import cr.ac.tec.DataSaved.InfoTree.ChefTree;
import cr.ac.tec.DataSaved.InfoTree.TreeConsultant;
import cr.ac.tec.DataSaved.InfoTree.UserTree;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import cr.ac.tec.DataStructures.LinkedList.List.Adapter.ArrayListAdapter;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Recipe implements Tagged {
    @Expose(serialize = false,deserialize = false)
    private final static int IDState=0;
    @Expose(serialize = false, deserialize = false)
    private final static int DateState=1;
    @Expose(serialize = false,deserialize = false)
    private final static int ScoreState=2;
    @Expose(serialize = false,deserialize = false)
    private final static int DifficultyState=3;
    @Expose(serialize = false, deserialize = false)
    private static int IdGiver=0;
    private ArrayList<String> subscribers;
    private int id;//Instance identifier
    private String RecipeName;
    private String Author;
    private int portions; //price
    private int amount;
    private ArrayList<String> Tags;
    private int grade; // Recipe Grade
    private int reviewNumber;//Number of user who have reviewed the recipe
    private String[] Steps;
    private String[] IngredientList;
    private Difficulty difficulty;
    private Date date;
    private int comparingState=0;
    public Recipe(){

    }
    public Recipe(int ID){
        this.id=ID;
    }
    public void build(builder builder){
        if(builder==null)return;
        builder.fusing();
        if(builder==null)return;
        this.grade=0;
        this.id=IdGiver;
        this.RecipeName=builder.RecipeName;
        this.Author=builder.Author;
        this.difficulty=builder.difficulty;
        this.portions=builder.portions;
        this.amount=builder.amount;
        this.IngredientList=builder.IngredientList;
        this.Steps=builder.Steps;
        this.Tags=builder.tags;
        this.date=new Date();
        this.reviewNumber=0;
        this.subscribers=new ArrayList<>();
        IdGiver++;
    }
    public void setScore(int data){
        this.grade=data;
    }

    public Date getDate() {
        return date;
    }
    public int getID(){
        return id;
    }

    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(o.getClass()!=this.getClass())return 1;
        if(o==this)return 0;
        Recipe Other=(Recipe)o;
        switch (comparingState){
            case IDState:
                return compareByID(Other);
            case DateState:
                return compareByDate(Other);
            case ScoreState:
                return compareByScore(Other);
            case DifficultyState:
                return compareByDifficulty(Other);
        }
        return 1;
    }
    private int compareByID(Recipe Other){
        if(Other==null)return 1;
        if(this.id==Other.id)return 0;
        if(this.id>Other.id)return 1;
        return -1;
    }
    private int compareByScore(Recipe otherRecipe){
        if(otherRecipe==null)return 1;
        if(otherRecipe==this)return 0;
        if(grade==otherRecipe.grade)return 0;
        if(grade>otherRecipe.grade)return 1;
        return -1;
    }
    private int compareByDate(Recipe otherRecipe){
        System.out.println("Llegue al mundo de mew");
        if(otherRecipe==null)return 1;
        if(otherRecipe==this)return 0;
        return date.compareTo(otherRecipe.date);
    }
    private int compareByDifficulty(Recipe otherRecipe){
        if(otherRecipe==null)return 1;
        if(otherRecipe==this)return 0;
        return difficulty.compareTo(difficulty);
    }
    public void setComparingState(int data){
        if(data<IDState || data>DifficultyState)return;
        comparingState=data;
    }
    public void abbObserver(RecipeOwners recipeOwners){
        if(recipeOwners==null)return;
        subscribers.add(recipeOwners.toString());
    }
    public void deleteObserver(RecipeOwners recipeOwners){
        if(recipeOwners==null)return;
        if(!subscribers.contains(recipeOwners.toString()))return;
        subscribers.remove(recipeOwners.toString());
    }
    public void deleteRecipe(){
        for(int i=0;i<subscribers.size();i++){
            TreeConsultant.RecipeOwner(subscribers.get(i)).getMyMenu().delete(this);
        }
    }
    public String stringing() {
        return "Recipe{" +
                "id=" + id +
                ", RecipeName='" + RecipeName + '\'' +
                ", Author='" + Author + '\'' +
                ", portions=" + portions +
                ", amount=" + amount +
                ", Tags=" + Tags +
                ", grade=" + grade +
                ", Steps=" + Arrays.toString(Steps) +
                ", IngredientList=" + Arrays.toString(IngredientList) +
                '}';
    }

    @Override
    public String toString() {
        return RecipeName;
    }

    @Override
    public DoubleList<String> getTags() {
        return new ArrayListAdapter<String>(Tags);

    }
    public class builder{
        private String RecipeName;
        private String Author;
        private int portions;
        private RecipeKind recipeKind;
        private RecipeTime recipeTime;
        private RecipeRoll recipeRoll;
        private Difficulty difficulty;
        private DoubleList<DietType> dietType;
        private String[] IngredientList;
        private String[] Steps;
        private ArrayList<String> tags;
        private int amount;

        public builder setRecipeName(String name){
            this.RecipeName=name;
            return this;
        }

        public builder setAuthor(String author) {

            this.Author =author;
            return this;
        }

        public builder setRecipeKind(String recipeKind) {
            this.recipeKind = RecipeKind.valueOf(recipeKind);
            return this;
        }

        public builder setPortions(int portions) {
            this.portions = portions;
            return this;
        }

        public builder setRecipeTime(String recipeTime) {
            this.recipeTime = RecipeTime.valueOf(recipeTime);
            return this;
        }

        public builder setRecipeRoll(String recipeRoll) {
            this.recipeRoll = RecipeRoll.valueOf(recipeRoll);
            return this;
        }

        public builder setDifficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public builder setDietType(String... diets) {
            this.dietType = new DoubleList<>();
            if(diets!=null){
                for(int i=0;i<diets.length;i++){
                    dietType.AddTail(DietType.valueOf(diets[i]));
                }
            }
            return this;
        }

        public builder setIngredientList(String... ingredient) {
            IngredientList=ingredient;
            return this;
        }

        public builder setSteps(String... steps) {
            this.Steps=steps;
            return this;
        }

        public builder setAmount(int amount) {
            this.amount = amount;
            if(this.amount<0)this.amount=0;
            return this;
        }
        private void fusing(){
            DoubleList<String> List=new DoubleList<>();
            List.AddTail(recipeTime.toString());
            List.AddTail(recipeKind.toString());
            List.AddTail(recipeRoll.toString());
           // List.AddTail(difficulty.toString());
            LinkedListTool<String> tool=new LinkedListTool<>();
            DoubleList<String> tempDiets=LinkedListTool.toStringList(dietType);
            List=tool.Merge(List,tempDiets);
            this.tags=tool.toJavaList(List);
        }

    }
}
