package cr.ac.tec.DataSaved.ClientLogin;

import com.google.gson.Gson;

import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.Files.JsonExchange;
import cr.ac.tec.Files.PlainText;
import cr.ac.tec.Files.jsonSource;

import java.util.ArrayList;

public class UserTree implements jsonSource {
    private static UserTree instance;
    private BinaryTree<User> Tree;
    private final String route="/Resources";
    private final String saved="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\COOKTIMEProyect\\resources\\JsonFiles\\Users.json";
    private UserTree(){
        Tree=new BinaryTree<>();
        this.getData();
    }
    public boolean  attach(User user){
        if(user==null)return false;
        if(isUser(user)) return false;
        Tree.insertion(user);
        ArrayList<User> arrayList=Tree.getArrayList();
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        Gson gson=new Gson();
        PlainText.writeFile(route,gson.toJson(arrayList));
        return true;
    }
    public static UserTree getInstance(){
        if(instance==null){
            instance=new UserTree();
        }
        return instance;
    }
    public boolean isUser(User user){
        return Tree.inTree(user);
    }
    public User getUser(User user){ return Tree.get(user); }

    @Override
    public void getData() {
        User[] array =(User[])JsonExchange.getList(route, User[].class);
        Tree.append(array);
    }
}
