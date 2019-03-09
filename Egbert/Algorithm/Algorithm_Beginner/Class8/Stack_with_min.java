public class Solution {
  Deque<Integer> stack;
  Deque<Integer> minStack;
  public Solution() {
    stack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1; 
    }
    int num = stack.pop();
    if (num <= minStack.peek()) {
      minStack.pop(); 
    }
    return num;
  }
  
  public void push(int element) {
    stack.push(element);
    if (minStack.isEmpty() || element <= minStack.peek()) {
      minStack.push(element); 
    }
  }
  
  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }
  
  public int min() {
    if (minStack.isEmpty()) {
      return -1;
    }
    return minStack.peek();
  }
}
