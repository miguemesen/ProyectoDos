package cr.ac.tec.DataSaved.ClientLogin;

import com.google.gson.Gson;

import cr.ac.tec.DataSaved.InfoTree;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.Files.JsonExchange;

public class UserTree extends InfoTree<User> {
    private static UserTree instance;
    private UserTree(){
        Tree=new BinaryTree<>();
        this.getData();
        this.route="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\COOKTIMEProyect\\web\\Resources\\JsonFiles\\Users.json";
    }

    public static UserTree getInstance(){
        if(instance==null){
            instance=new UserTree();
        }
        return instance;
    }
    @Override
    public void getData() {
        User[] array =(User[])JsonExchange.getObjectFromJson(route, User[].class);
        Tree.append(array);
    }
}
