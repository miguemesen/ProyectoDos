package cr.ac.tec.TextMatching;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Set;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFinder<T extends Comparable> {
    final int init=0;
    public Set<T> matching(DoubleList<T> source, String toFind){
        if(verification(source,toFind)==null)return null;
        return getMatch(source,toFind,new Set<>(null));
    }
    protected Set<T> getMatch(DoubleList<T> source, String request, Set<T> returning){
        if(request==null || request.equals(""))return returning;
        if(returning==null)return null;
        String Regex="^"+request;
        Regex=request;
        Pattern pattern=Pattern.compile(Regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        T element;
        for(int i=0;i<source.getLength();i++){
            element=source.get(i);
            if(pattern.matcher(element.toString()).find())returning.AddTail(element);
        }
        request=request.substring(init,request.length()-1);
        return getMatch(source,request,returning);
    }
    protected  DoubleList<T> verification(DoubleList<T> source, String toFind){
        if(source==null)return null;
        if(toFind==null)return null;
        return source;
    }

}
