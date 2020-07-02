package cr.ac.tec.DataSaved;

import cr.ac.tec.DataStructures.Tree.BinaryTree;

public class UserTree {
    private static UserTree instance;
    private BinaryTree<User> Tree;
    private UserTree(){
        Tree=new BinaryTree<>();
    }
    public boolean  attach(User user){
        if(user==null)return false;
        Tree.insertion(user);
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
}
