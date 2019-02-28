package main.java.onlinejudges.codeforces.solutions.closed.gcj1;

import java.io.*;
import java.util.StringTokenizer;

public class _gcj1a_a {

    /*

7
CAB
JAM
CODE
ABAAB
CABCBBABC
ABCABCABC
ZXCASDQWE

     */
    public static void solution(BufferedReader reader, PrintWriter out)
            throws IOException {
        In in = new In(reader);

        int tcn = in.nextInt();

        for(int t = 1; t <= tcn; t++) {

            String s = in.next();

            StringBuilder sb = new StringBuilder();

            char leadingChar = 'A';

            for(char c : s.toCharArray()) {
                if(c >= leadingChar) {
                    sb.insert(0, c);
                    leadingChar = c;
                }
                else {
                    sb.append(c);
                }
            }

            out.print("Case #" + t + ": " + sb.toString() + "\n");

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        solution(reader, out);
        out.close();
    }

    protected static class In {
        private BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public In(BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}



