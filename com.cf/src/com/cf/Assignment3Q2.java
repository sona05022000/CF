package com.cf;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Assignment3Q2 {
    public static HashSet<String> unorderedHashSet() {
        HashSet<String> set = new HashSet<String>();
        set.add("dog");
        set.add("cat");
        set.add("lion");
        set.add("elephant");
        set.add("tiger");
        return set;
    }

    public static LinkedHashSet<String> orderedLinkedHashSet() {
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        set.add("dog");
        set.add("cat");
        set.add("lion");
        set.add("elephant");
        set.add("tiger");
        return set;
    }

    public static void main(String[] args) {
        HashSet<String> unorderedSet = unorderedHashSet();
        LinkedHashSet<String> orderedSet = orderedLinkedHashSet();

        System.out.println("Unordered HashSet: " + unorderedSet);
        System.out.println("Ordered LinkedHashSet: " + orderedSet);
    }
}
