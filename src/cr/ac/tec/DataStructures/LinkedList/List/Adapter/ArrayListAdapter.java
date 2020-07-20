package cr.ac.tec.DataStructures.LinkedList.List.Adapter;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

import java.util.ArrayList;

public class ArrayListAdapter<T> extends DoubleList<T> {
    private ArrayList<T> arrayList;
    public ArrayListAdapter(ArrayList arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public void AddTail(T Newinfo) {
        if(!verification())return;
        arrayList.add(Newinfo);

    }

    @Override
    public void AddHead(T NewInfo) {
        if(!verification())return;
        arrayList.add(0,NewInfo);
    }

    @Override
    public void delete(int position) {
        if(!verification())return;
        if(position>= arrayList.size())return;
        arrayList.remove(position);
    }


    private boolean verification(){
        if(arrayList==null ||  arrayList.size()<=0)return false;
        return true;
    }
}
