package com.king.bean.list;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    public static final Integer[] undoneTaskStatusArray = { 1, 2, 4 };

    public static void main(String[] args) {
        /*
            java.util.Arrays
        
            This class contains various methods for manipulating arrays (such as sorting and searching).
            This class also contains a static factory that allows arrays to be viewed as lists.
            
            The methods in this class all throw a NullPointerException, if the specified array reference is null, except where noted. 
            The documentation for the methods contained in this class includes briefs description of the implementations.
            
            Such descriptions should be regarded as implementation notes, rather than parts of the specification.
            Implementors should feel free to substitute other algorithms, so long as the specification itself is adhered to.
            (For example, the algorithm used by sort(Object[]) does not have to be a MergeSort, but it does have to be stable.)
            
            This class is a member of the  Java Collections Framework.
         */
        List<Integer> iList = Arrays.asList(undoneTaskStatusArray);
        for (Integer elem : iList) {
            System.out.println(elem);
        }
        
        List<Integer> manulList = Arrays.asList(3, 5, 6);
        for (Integer elem : manulList) {
            System.err.println(elem);
        }
    }

}
