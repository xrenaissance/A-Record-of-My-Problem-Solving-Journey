package main.interview.priorityqueue_comparator;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {

//        // for comparison
//        int NameCompare = customer1.getName().compareTo(customer2.getName());
//        int AgeCompare = customer1.getAge().compareTo(customer2.getAge());
//
//        // 2-level comparison using if-else block
//        if (NameCompare == 0) {
//            return ((AgeCompare == 0) ? NameCompare : AgeCompare);
//        } else {
//            return NameCompare;
//        }

        return customer2.getId() - customer1.getId();
    }
}