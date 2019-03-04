package main.interview.sort.annoymouscomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String args[]){
        ArrayList<Student> arraylist = new ArrayList<Student>();
        arraylist.add(new Student(2222, "Chaitanya", 16));
        arraylist.add(new Student(888, "Rahul", 24));
        arraylist.add(new Student(600, "Ajeet", 99));

        Collections.sort(arraylist, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getRollno() - o2.getRollno();
            }
        });

        for(Student str: arraylist){
            System.out.println(str);
        }
    }
}
