public class queue {
  Deque<Integer> in;
  Deque<Integer> out;
  public queue() {
    in = new LinkedList<>();
    out = new LinkedList<>();
  }
  public void shuffleIfNecessary() {
    if (in.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerFirst(in.pollFirst); 
      } 
    }
  }
  public void push(Integer num) {
    in.offerFirst(num); 
  }
  public int size() {
    return in.size() + out.size();
  }
}
