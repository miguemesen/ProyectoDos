package cr.ac.tec.TextMatching;

import cr.ac.tec.DataSaved.InAppData.Tags.Tagged;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Set;

public class TextMatcherWithTags<T extends Tagged> extends cr.ac.tec.TextMatching.TextFinder<T> {
    public Set<T> matching(DoubleList<T> source, String toFind, String ...tags) {
        Set<T> List=super.matching(source, toFind);
        if(tags==null)return List;
        if(List==null)return null;
        DoubleList<String> ObjectTags;
        for(int i=0;i<List.getLength();i++){
            ObjectTags=List.get(i).getTags();
            if(!hasAll(ObjectTags,tags)){
                List.delete(i);
                i--;
            }
        }

        return List;
    }
    private boolean hasAll(DoubleList<String> List, String[] strings){
        if(List==null || strings==null)return false;
        String element;
        for(int i=0;i<strings.length;i++){
            element=strings[i];
            for(int j=0;j<List.getLength();j++){
                if(element.equals(List.get(j)))j=List.getLength();
                if(j==List.getLength()-1 && !element.equalsIgnoreCase(List.get(j)))return false;

            }
        }
        return true;

    }


}
