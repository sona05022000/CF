package com.cf;
import java.util.ArrayList;
import java.util.ListIterator;

public class Assignment3Q3 {
    public static void traverseReverse(ArrayList<String> aList) {
        ListIterator<String> itr = aList.listIterator(aList.size());
        while(itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }

    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();
        aList.add("apple");
        aList.add("banana");
        aList.add("cherry");
        traverseReverse(aList);
    }
}
