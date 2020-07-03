package cr.ac.tec.DataSaved.ClientLogin;

import cr.ac.tec.DataStructures.Tree.BinaryTree;

public class UserTree {
    private static UserTree instance;
    private BinaryTree<Client> Tree;
    private UserTree(){
        Tree=new BinaryTree<>();
    }
    public boolean  attach(Client client){
        if(client ==null)return false;
        if(isUser(client)) return false;
        Tree.insertion(client);
        return true;
    }
    public static UserTree getInstance(){
        if(instance==null){
            instance=new UserTree();
        }
        return instance;
    }
    public boolean isUser(Client client){
        return Tree.inTree(client);
    }
    public Client getUser(Client client){
        return Tree.get(client);
    }
}
