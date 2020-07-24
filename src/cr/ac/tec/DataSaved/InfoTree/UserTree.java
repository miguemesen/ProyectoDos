package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.Files.JsonExchange;

public class UserTree extends InfoTree<User> {
    private static UserTree instance;
    private UserTree(){

        route="C:\\Users\\migue\\OneDrive\\Escritorio\\SegundoProyectoDatos1\\web\\Resources\\JsonFiles\\Users.json";
        Tree=new BinaryTree<>();
        this.getData();
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
