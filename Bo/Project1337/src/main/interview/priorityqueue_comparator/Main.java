package main.interview.priorityqueue_comparator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //优先队列自然排序示例
        Random rand = new Random();

        //方法1 - nature
//        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
//        for(int i=0;i<7;i++){
//            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
//        }
//        for(int i=0;i<7;i++){
//            Integer in = integerPriorityQueue.poll();
//            System.out.println("Processing Integer:"+in);
//        }


        Comparator<Customer> idComparator = new CustomerComparator();
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);

        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
        }

        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Processing Customer with ID="+cust.getId());
        }

    }

}


