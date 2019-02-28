package main.java.onlinejudges.codeforces.stubs;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class NewStub {

    /*

4
2
2 2
3
3 2 2
3
1 1 2
3
2 3 1

     */
    public static void solution(BufferedReader reader, PrintWriter out)
            throws IOException {
        In in = new In(reader);

        int tcn = in.nextInt();


        // TODO pre calculate n's all combination from n -> 3. P = 2 is guaranteed to be possible
        for (int t = 1; t <= tcn; t++) {

            int pn = in.nextInt();

            List<Integer> plist = new ArrayList<Integer>();

            int max = 0;
            int total = 0;

            // Input + calculate max
            for (int i = 0; i < pn; i++) {
                int p = in.nextInt();
                max = p > max ? p : max;
                total += p;
                plist.add(p);
            }

            StringBuilder sb = new StringBuilder();

            while (total > 0)

            sb.setLength(sb.length() - 1);

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



