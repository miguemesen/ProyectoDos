package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.Tree.AVLTree;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.Files.JsonExchange;
import cr.ac.tec.Files.PlainText;


public class RecipeTree extends InfoTree<Recipe> {
    private static RecipeTree instance;
    private String IndexRoute;
    public RecipeTree(){
        Tree=new BinaryTree<>();
        route="C:\\Users\\migue\\OneDrive\\Documentos\\Proyecto2\\SegundoProyectoDatos1\\web\\Resources\\JsonFiles\\Recipes.json";
        IndexRoute="C:\\Users\\migue\\OneDrive\\Documentos\\Proyecto2\\SegundoProyectoDatos1\\web\\Resources\\JsonFiles\\RecipeID.txt";
        Recipe.setIdGiver(PlainText.readNumber(IndexRoute));
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

    @Override
    public boolean attach(Recipe info) {
        boolean condition= super.attach(info);
        PlainText.writeFile(IndexRoute,String.valueOf(Recipe.getIdGiver()));
        return condition;
    }
}
