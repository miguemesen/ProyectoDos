package cr.ac.tec.DataSaved.InAppData.Recipes;

import cr.ac.tec.DataSaved.ClientLogin.Client;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.DietType;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.RecipeKind;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.RecipeRoll;
import cr.ac.tec.DataSaved.InAppData.Tags.RecipeTags.RecipeTime;
import cr.ac.tec.DataSaved.InAppData.Tags.Tagged;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;

public class Recipe implements Tagged {
    private static int IdGiver=0;
    private int id;//Instance identifier
    private String RecipeName;
    private String Author;
    private int portions; //price
    private int amount;
    private DoubleList<String> Tags;
    private int grade; // Recipe Grade
    private DoubleList<Step> Steps;
    private DoubleList<Ingredient> IngredientList;
    private DoubleList<Client> Users; //List of user who have graded the recipe
    public Recipe(){

    }
    public void build(builder builder){
        if(builder==null)return;
        this.grade=0;
        this.Users=new DoubleList<>();
        this.id=IdGiver;
        this.RecipeName=builder.RecipeName;
        this.Author=builder.Author;
        this.portions=builder.portions;
        this.amount=builder.amount;
        this.Steps=builder.steps;
        this.IngredientList=builder.IngredientList;
        Tags=new DoubleList<>();
        Tags.AddTail(builder.recipeKind.toString());
 //      Tags.AddTail(builder.recipeTime.toString());
     //   Tags.AddTail(builder.recipeRoll.toString());
       //Tags.AddTail(builder.difficulty.toString());
        //ToStringList method get a List with the String of each member of a DoubleList
        LinkedListTool<String> Tools=new LinkedListTool<>();
        DoubleList<String> Diets=Tools.toStringList(builder.dietType);
        Tags=Tools.Merge(Tags,Diets);
        IdGiver++;
    }

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String recipeName) {
        RecipeName = recipeName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }





    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(o.getClass()!=this.getClass())return 1;
        if(o==this)return 0;
        Recipe Other=(Recipe)o;
        if(this.id==Other.id)return 0;
        if(this.id>Other.id)return 1;
        return -1;

    }

    @Override
    public String toString() {
        return RecipeName;
    }

    @Override
    public DoubleList<String> getTags() {
        return Tags;
    }

    public class builder{
        private String RecipeName;
        private String Author;
        private RecipeKind recipeKind;
        private int portions;
        private RecipeTime recipeTime;
        private RecipeRoll recipeRoll;
        private Difficulty difficulty;
        private DoubleList<DietType> dietType;
        private DoubleList<Ingredient> IngredientList;
        private DoubleList<Step> steps;
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

        public builder setIngredientList(Ingredient... ingredient) {
            IngredientList = new DoubleList<>();
            if(ingredient!=null){
                for(int i=0;i<ingredient.length;i++){
                    IngredientList.AddTail(ingredient[i]);
                }
            }
            return this;
        }

        public builder setSteps(Step... steps) {
            Steps = new DoubleList<>();
            if(steps!=null){
                for(int i=0;i<steps.length;i++){
                    Steps.AddTail(steps[i]);
                }
            }
            return this;
        }

        public builder setAmount(int amount) {
            this.amount = amount;
            if(this.amount<0)this.amount=0;
            return this;
        }
    }
}
