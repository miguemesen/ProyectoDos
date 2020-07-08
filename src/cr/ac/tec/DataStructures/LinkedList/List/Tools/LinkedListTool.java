package cr.ac.tec.DataStructures.LinkedList.List.Tools;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

public class LinkedListTool<T> {
    public  DoubleList<T> Merge(DoubleList<T>...Lists){
        DoubleList<T> returning=new DoubleList<>();
        DoubleList<T> List;
        if(Lists!=null) {
            for (int i = 0; i < Lists.length; i++) {
                List = Lists[i];
                for (int j = 0; j < List.getLength(); j++) {
                    returning.AddTail(List.get(j));
                }
            }
        }
        return returning;
    }
    public DoubleList<String> toStringList(DoubleList List){
        DoubleList<String> returning=new DoubleList<>();
        if(List!=null) {
            for (int i = 0; i < List.getLength(); i++) {
                returning.AddTail(List.get(i).toString());
            }
        }
        return returning;
    }
}
