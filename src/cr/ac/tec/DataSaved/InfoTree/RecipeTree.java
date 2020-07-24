package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataStructures.Tree.AVLTree;
import cr.ac.tec.Files.JsonExchange;

public class RecipeTree extends InfoTree<Recipe> {
    private static RecipeTree instance;
    public RecipeTree(){
        Tree=new AVLTree<>();
        route="C:\\Users\\Gabriel Solano\\Documents\\GitHub\\SegundoProyectoDatos1\\web\\Resources\\JsonFiles\\Recipe.json";
        getData();
    }
    public static RecipeTree getInstance(){
        if(instance==null){
            synchronized (RecipeTree.class){
                if(instance==null){
                    instance=new RecipeTree();//Duplicate code to improve the threat management
                }
            }
        }
        return instance;
    }
    @Override
    public void getData() {
        Recipe[] recipes=(Recipe[]) JsonExchange.getObjectFromJson(route,Recipe[].class);
        Tree.append(recipes);

    }
}
