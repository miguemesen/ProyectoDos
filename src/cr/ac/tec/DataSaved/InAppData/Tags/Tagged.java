package cr.ac.tec.DataSaved.InAppData.Tags;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Sorting.Numerable;

public interface Tagged<T> extends Numerable<T> {
    public DoubleList<String> getTags();

}
