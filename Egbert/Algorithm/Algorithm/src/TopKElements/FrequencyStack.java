package TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @leetcode https://leetcode.com/problems/maximum-frequency-stack/
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6223867750121472
 * @Time log N for both operations
 * @Space O 2 * N
 */
public class FrequencyStack {
    public PriorityQueue<Element> maxHeap = new PriorityQueue<>(
            (e1, e2) -> {
                if (e1.frequence != e2.frequence) {
                    return e2.frequence - e1.frequence;
                }
                return e2.sequenceNumber - e1.sequenceNumber;
            }
    );
    public Map<Integer, Integer> numFreq = new HashMap<>();
    public int sequenceNumber;
    // log N
    public void push(int num) {
        numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        maxHeap.offer(new Element(num, numFreq.get(num), this.sequenceNumber++));
    }
    // log N
    public int pop() {
        int num = maxHeap.poll().number;
        if (numFreq.get(num) > 1) {
            numFreq.put(num, numFreq.get(num) - 1);
        } else {
            numFreq.remove(num);
        }
        return num;
    }
    public static class Element {
        int number;
        int frequence;
        int sequenceNumber;
        public Element(int number, int frequence, int sequenceNumber) {
            this.number = number;
            this.frequence = frequence;
            this.sequenceNumber = sequenceNumber;
        }
    }
    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(5);
        frequencyStack.push(7);
        frequencyStack.push(5);
        frequencyStack.push(7);
        frequencyStack.push(4);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
