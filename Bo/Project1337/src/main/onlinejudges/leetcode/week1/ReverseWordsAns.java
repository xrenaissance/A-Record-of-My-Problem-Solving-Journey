package main.onlinejudges.leetcode.week1;

public class ReverseWordsAns {

    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int start = 0;
        for (int pos = 0; pos < str.length; pos++) {
            if (str[pos] == ' ') {
                reverse(str, start, pos - 1);
                start = pos + 1;
            }
        }
        reverse(str, start, str.length - 1);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}



