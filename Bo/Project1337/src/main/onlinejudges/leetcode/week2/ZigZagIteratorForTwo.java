package main.onlinejudges.leetcode.week2;

import java.util.ArrayList;
import java.util.List;

public class ZigZagIteratorForTwo {

    int ptr1;
    int ptr2;

    List<Integer> list1;
    List<Integer> list2;


    public ZigZagIteratorForTwo(List<Integer> list1, List<Integer> list2) {
        this.list1 = new ArrayList<>(list1);
        this.list2 = new ArrayList<>(list2);

        int ptr1 = 0;
        int ptr2 = 0;

    }

    // Should use global counter like
    // return c1 + c2 < v1.size() + v2.size();
    public boolean hasNext() {
        if((list1 != null && ptr1 < list1.size()) || (list2 != null && ptr2 < list2.size()))
            return true;
        return false;
    }

    public Integer next() {
        if(!hasNext())
            return null;
        if(ptr1 == list1.size())
            return list2.get(ptr2++);
        else if(ptr2 == list2.size())
            return list1.get(ptr1++);
        else {
            if (ptr1 == ptr2)
                return list1.get(ptr1++);
            else
                return list2.get(ptr2++);
        }
    }

    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        ZigZagIteratorForTwo z = new ZigZagIteratorForTwo(list1, list2);

        while(z.hasNext()) {
            System.out.print(z.next());
        }
    }
}
