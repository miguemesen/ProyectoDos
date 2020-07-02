package cr.ac.tec.DataStructures.Tree;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;

public class BinaryTree<T extends Comparable> implements Balancer<T>{
    protected DoubleNode root;
    final boolean isEmpty(){
       return root==null;
    }
    final public boolean contains(T data){
        return getNode(root,data)!=null;

    }
    final protected DoubleNode<T> getNode(DoubleNode<T> node,T data){
        if(node==null || node.getInfo().compareTo(data)==0)return node;
        if(data.compareTo(node.getInfo())>0)return getNode(node.getFront(),data);
        else return getNode(node.getBack(),data);

    }
    final public void insertion(T data){
        this.root=insertions(root,data);

    }
    protected DoubleNode<T> insertions(DoubleNode<T> current, T data){
        DoubleNode<T> node;
        if(current==null)return new DoubleNode<T>(data);
        if(data.compareTo(current.getInfo())==0)return current;
        boolean condition=data.compareTo(current.getInfo())>0;
        if(condition){
            current.setFront(insertions(current.getFront(),data));
        }
        else{
            current.setBack(insertions(current.getBack(),data));
        }

        return Balance(current);
    }
    final public void deletion(T data){
        this.root=delete(root,data);

    }
    protected DoubleNode<T> delete(DoubleNode<T> node,T data){
        if(node==null)return null;
        if(data.compareTo(node.getInfo())>0){
            node.setFront(delete(node.getFront(),data));
        }
        else if(data.compareTo(node.getInfo())<0){
            node.setBack(delete(node.getBack(),data));
        }
        else if(node.getBack()==null && node.getFront()==null){
            node=null;
        }
        else {
            DoubleNode<T> temp;
            T info;
            if(node.getFront()!=null){
                temp=findMin(node.getFront());
                info=temp.getInfo();
                node.setFront(delete(node.getFront(),info));

            }
            else {
                temp=findMax(node.getBack());
                info=temp.getInfo();
                node.setBack(delete(node.getBack(),info));
            }

            node.setInfo(temp.getInfo());
        }
        return Balance(node);



    }
    public DoubleNode<T> findMin(DoubleNode<T> node){
        if(node==null)return null;
        while(node.getBack()!=null){
            node=node.getBack();
        }
        return node;
    }
    public DoubleNode<T> findMax(DoubleNode<T> node){
        if(node==null)return null;
        while(node.getFront()!=null){
            node=node.getFront();
        }
        return node;
    }
    public DoubleNode<T> getRoot(){
        return root;
    }
    public DoubleList<T> getListInOrder(){
        DoubleList<T> List=new DoubleList<>();
        gettingListInOrder(List,root);
        return List;
    }
    private void gettingListInOrder(DoubleList<T> List,DoubleNode<T> Node){
        if(Node==null)return;
        gettingListInOrder(List,Node.getBack());
        List.AddTail(Node.getInfo());
        gettingListInOrder(List,Node.getFront());
    }
    public DoubleList<T> getListPreOrder(){
        DoubleList<T> List=new DoubleList<>();
        gettingListPreOrder(List,root);
        return List;

    }
    private void gettingListPreOrder(DoubleList<T> List, DoubleNode<T> node){
        if(node==null)return;
        List.AddTail(node.getInfo());
        gettingListPreOrder(List,node.getBack());
        gettingListPreOrder(List,node.getFront());
    }
    public DoubleList<T> getListPostOrder(){
        DoubleList<T> List= new DoubleList<>();
        gettingPostOrder(List,root);
        return List;

    }
    private void gettingPostOrder(DoubleList<T> List, DoubleNode<T> node){
        if(node==null)return;
        gettingPostOrder(List,node.getBack());
        gettingPostOrder(List,node.getFront());
        List.AddTail(node.getInfo());
    }
    public int getHeight(){
        return getHeight(root);
    }

    protected  int getHeight(DoubleNode<T> Node){
        if(Node==null) return 0;
        int RightHeight=getHeight(Node.getFront());
        int LeftHeight=getHeight(Node.getBack());
        if(LeftHeight>RightHeight)return LeftHeight+1;
        return 1+RightHeight;
    }


    @Override
    public DoubleNode<T> Balance(DoubleNode<T> Node) {
        return Node;
    }
    public boolean inTree(T data){
        return inTree(root,data);

    }
    private boolean inTree(DoubleNode<T> Node,T data){
        if(Node==null)return false;
        if(data.compareTo(Node.getInfo())>0)return inTree(Node.getFront(),data);
        return inTree(Node.getBack(),data);
    }
}
