public class Solution {
  private Deque<Integer> in;
  private Deque<Integer> out;
  public Solution() {
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }
  
  private void shuffleIfNecessary() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop()); 
      }
    }
  }
  public Integer poll() {
    shuffleIfNecessary();
    if (!out.isEmpty()) {
      return out.pop(); 
    }
    return null;
  }
  
  public void offer(int element) {
    in.push(element);
  }
  
  public Integer peek() {
    shuffleIfNecessary();
    if (!out.isEmpty()) {
      return out.peek(); 
    }
    return null;
  }
  
  public int size() {
    return in.size() + out.size();
  }
  
  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }
}
