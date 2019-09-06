package DynamicProgramming.Knapsack;

import java.lang.reflect.Array;

public class Test<T> {

    private T[] array;

    public Test(Class<T> type,int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index,T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        Test<Integer> array = new Test<Integer>(Integer.class,100);
        //this is worked
        Integer[] rep = array.rep();
        Test<String> array2 = new Test<>(String.class, 100);
        String[] rep2 = array2.rep();
    }

    public T[] rep() {
        return array;
    }
}
