package main.java.onlinejudges.codeforces.solutions.closed.gcj1;

import java.io.*;
import java.util.*;

public class _gcj1a_b {

    /*

1
3
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3


2
3
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3
4
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
1 2 3 4
2 3 4 5
3 4 5 6

     */
    public static void solution(BufferedReader reader, PrintWriter out)
            throws IOException {
        In in = new In(reader);

        int tcn = in.nextInt();

        for(int t = 1; t <= tcn; t++) {

            int n = in.nextInt();

            Set<Integer> set = new HashSet<Integer>();

            for (int i = 0; i < n * n * 2 - n; i++) {
//                out.print("Case #" + t + ": "
//                        + " + i = " + i + ", h = " + in.nextInt() + "\n");
                int h = in.nextInt();
                if(set.contains(h))
                    set.remove(h);
                else
                    set.add(h);
            }

            List<Integer> list = new ArrayList<Integer>(set);
            Collections.sort(list);

            out.print("Case #" + t + ": ");

            for (int i = 0; i < list.size() - 1; i ++) {
                out.print(list.get(i) + " ");
            }

            out.print(list.get(list.size() - 1) + "\n");
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



