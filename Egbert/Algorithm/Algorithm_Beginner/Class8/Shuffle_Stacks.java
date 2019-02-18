class Solution {
	public void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
    while (stack1.size() > 0) {
      stack2.push(stack1.pop()); 
    }
	}
}
