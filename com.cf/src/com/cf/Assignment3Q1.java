package com.cf;
import java.util.*;

class Person implements Comparable<Person> {
    private String name;
    private int height;
    private double weight;
    
    public Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHeight() {
        return height;
    }
    
    public double getWeight() {
        return weight;
    }
    
    @Override
    public int compareTo(Person other) {
        if (this.weight != other.weight) {
            return Double.compare(this.weight, other.weight);
        } else {
            return Integer.compare(this.height, other.height);
        }
    }
}
public class Assignment3Q1 {
    public static void main(String[] args) {
        TreeSet<Person> persons = new TreeSet<>();
        persons.add(new Person("venkata", 60, 55.0));
        persons.add(new Person("aiyar", 70, 60.0));
        persons.add(new Person("shiva", 65, 65.0));
        persons.add(new Person("mura", 75, 60.0));
        
        for (Person person : persons) {
            System.out.printf("%s: height=%d, weight=%.1f\n", person.getName(), person.getHeight(), person.getWeight());
        }
    }
}
