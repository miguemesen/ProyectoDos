package cr.ac.tec.DataSaved.InAppData.Recipes;

import cr.ac.tec.DataStructures.Tree.AVLTree;

public class RecipeTree {
    private static RecipeTree instance;
    private AVLTree<Recipe> tree;
    private RecipeTree(){
        tree=new AVLTree<>();
    }
    public static RecipeTree getInstance(){
        if(instance==null) {
            synchronized (RecipeTree.class) {
                if(instance==null){
                    instance=new RecipeTree();//Duplicated code due to avoid delay in future petitions, with this setting, just the class that try to access to this method before having an instance will be looking after the sync
                }
            }
        }
        return instance;
    }
}
