package cr.ac.tec;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.DataStructures.Tree.SplayTree;
import cr.ac.tec.Files.PlainText;

public class ProvesLinkedList {
    public static void main(String[] args) {
        SplayTree<Integer> tree=new SplayTree<>();
        for(int i=3;i<10;i+=2){
            tree.insertion(i);
        }
      System.out.println(tree.getRoot().getInfo());

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------");

       tree.insertion(1);
       tree.insertion(2);
       tree.insertion(23);
        System.out.println(tree.inTree(9));
       //tree.insertion(10);
        //tree.get(9);
        DoubleNode<Integer> ro=tree.getRoot();
        System.out.println(ro.getInfo());

       //System.out.println(ro.getFront().getInfo());
        PlainText.writeFile("web/name.txt","Breaking the habits");
    }
}
