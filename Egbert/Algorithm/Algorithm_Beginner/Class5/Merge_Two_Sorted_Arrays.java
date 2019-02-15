public class Solution {
  public int[] merge(int[] one, int[] two) {
    int[] result = new int[one.length + two.length];
    int i = 0;
    int j = 0;
    int h = 0;
    while (h < result.length) {
      if (i >= one.length) {
        result[h] = two[j];
        j++;
      } else if (j >= two.length) {
        result[h] = one[i];
        i++;
      } else if (one[i] < two[j]) {
         result[h] = one[i];
         i++;
       } else {
         result[h] = two[j];
         j++;
       }
       h++;
    }
    return result;
  }
}
