class Solution {
	public int sumOfStack(Deque<Integer> stack) {
    int result = 0;
    while(stack.size() > 0) {
      result += stack.pop(); 
    }
    return result;
	}
}
