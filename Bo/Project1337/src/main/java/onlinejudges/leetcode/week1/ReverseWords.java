package main.java.onlinejudges.leetcode.week1;

public class ReverseWords {

    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int wordStart = 0;
        for(int ptr = 0; ptr < str.length; ptr ++) {
            if(str[ptr] == ' ') {
                reverse(str, wordStart, ptr - 1 );
                wordStart = ptr + 1;
            }
        }
        reverse(str, wordStart, str.length - 1);
    }

    public void reverse(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start ++;
            end --;
        }
    }
}



