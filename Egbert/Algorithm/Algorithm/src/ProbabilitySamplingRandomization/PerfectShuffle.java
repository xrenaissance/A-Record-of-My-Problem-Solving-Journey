package ProbabilitySamplingRandomization;

public class PerfectShuffle {
    // Iteration 1: call random(0 - 51) -> let's say, random_number = 5, call swap(5, 51)
    // P(every card can showup in position 51) = 1/52

    // Iteration 2: Call random(0 - 50) -> let's say, random_number1 = 8, call swap(8, 50)
    // Every card was NOT selected during previous iteration = 1 - 1/52
    // P(every card can showup in position 50) = (1 - 1/52) * 1/51 = 1/52

    // Iteration 3: call random(0 - 49) -> let's say, random_number1 = 7, call swap(7, 49)
    // Every card was NOT selected during previous iteration = 1 - 1/52
    // Every card was NOT selected curing previous iteration = 1 - 1/51
    // p(every card can showup in position 49) = (1 - 1/52) * (1 - 1/51) * 1/50 = 1/52
    public void shuffle(int[] array) {
        // Assumption: array is not null.
        if (array.length <= 1) {
            return;
        }
        // from right to left
        // for index i - 1, randomly pick one of the first i elements.
        for (int i = array.length; i >= 1; i--) {
            int index = (int) (Math.random() * i);
            swap(array, i - 1, index);
        }
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
