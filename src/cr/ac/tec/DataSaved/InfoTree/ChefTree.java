package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.Chef.Chef;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.Files.JsonExchange;

public class ChefTree extends InfoTree<Chef> {
    private static ChefTree instance;

    private ChefTree(){
        route="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\COOKTIMEProyect\\web\\Resources\\JsonFiles\\Chefs.json";
        Tree=new BinaryTree<>();
        getData();
    }

    @Override
    public void getData() {
        Chef[] chefs=(Chef[]) JsonExchange.getObjectFromJson(route,Chef.class);
        Tree.append(chefs);
    }
    public static ChefTree getInstance(){
        if(instance==null){
            instance=new ChefTree();
        }
        return instance;
    }
}
