package main.interview.sort.comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String args[]){
        ArrayList<Student> arraylist = new ArrayList<Student>();
        arraylist.add(new Student(223, "Chaitanya", 26));
        arraylist.add(new Student(245, "Rahul", 24));
        arraylist.add(new Student(209, "Ajeet", 32));

        Collections.sort(arraylist, new StudentComparator());

        for(Student str: arraylist){
            System.out.println(str);
        }
    }
}
