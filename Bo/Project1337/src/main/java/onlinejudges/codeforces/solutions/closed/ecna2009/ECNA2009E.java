package main.java.onlinejudges.codeforces.solutions.closed.ecna2009;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*

5
UUUDD
RRLL
5 1 2 3 4 5

10
UUDDUUDDUU
LLLRRRLRL
4 3 7 6 1

0

-----------------------

5
UUUDD
RRLL
5 1 2 3 4 5
10
UUDDUUDDUU
LLLRRRLRL
4 3 7 6 1
0

 */
public class ECNA2009E {

    // input
    static int n;
    static char[] ups, ops;
    static int[] qrys;

    // data types
    static int rpos, lpos;
    static List<Integer> lp, rp, finalp;
    static List<Boolean> lps, rps, finalps;

    // debug
    static int step = 0;

    // loop
    static int round = 1;

    public static void solution(BufferedReader reader, PrintWriter out)
            throws IOException {
        In in = new In(reader);

        while (true) {
            n = in.nextInt(); // L1 = n

            if (n == 0) {
                System.exit(0);
            }

            ups = in.next().toCharArray(); // L2 = sides
            ops = in.next().toCharArray(); // L3 = operations

            qrys = new int[in.nextInt()];   // L4 = queries
            for (int i = 0; i < qrys.length; i++)
                qrys[i] = in.nextInt();

            // Create + init L, R and final pile
            rpos = n;
            rp = new ArrayList<Integer>();
            rps = new ArrayList<Boolean>();

            rp.add(n);
            rps.add(ups[n - 1] == 'U');

            lpos = 1;
            lp = new ArrayList<Integer>();
            lps = new ArrayList<Boolean>();

            lp.add(1);
            lps.add(ups[0] == 'U');

            finalp = new ArrayList<Integer>();
            finalps = new ArrayList<Boolean>();

            // main loop
            for (int i = 0; i < n - 2; i++) {

                step++;

                if (ops[i] == 'L')
                    lFlip();
                else if (ops[i] == 'R')
                    rFlip();
            }

            if (ops[ops.length - 1] == 'L') {
                Collections.reverse(lp);
                Collections.reverse(lps);

                for (int i = 0; i < lps.size(); i++) {
                    lps.set(i, !lps.get(i));
                }

                lp.addAll(rp);
                lps.addAll(rps);

                finalp = lp;
                finalps = lps;
            } else {
                Collections.reverse(rp);
                Collections.reverse(rps);

                for (int i = 0; i < rps.size(); i++) {
                    rps.set(i, !rps.get(i));
                }

                rp.addAll(lp);
                rps.addAll(lps);

                finalp = rp;
                finalps = rps;
            }

            step++;

            // Result
            System.out.printf("Pile %d%n", round++);
            for (int i = 0; i < qrys.length; i++) {
                System.out.printf("Card %d is a face " + (finalps.get(qrys[i] - 1) ? "up" : "down") + " %d.%n", qrys[i], finalp.get(qrys[i] - 1));
            }

        }
    }

    static void printAll(PrintWriter out) {

        out.println("Step = " + step);

        out.println("Left P");
        for (int i = 0; i < lp.size(); i++)
            out.println("|" + lp.get(i) + " = " + lps.get(i) + "|");

        out.println("Right P");
        for (int i = 0; i < rp.size(); i++)
            out.println("|" + rp.get(i) + " = " + rps.get(i) + "|");

        out.println("final P");
        for (int i = 0; i < finalp.size(); i++)
            out.println("|" + finalp.get(i) + " = " + finalps.get(i) + "|");

        out.println("\n\n");

    }

    static void lFlip() {
        lpos++;

        // reverse Lp
        Collections.reverse(lp);
        Collections.reverse(lps);

        for (int i = 0; i < lps.size(); i++) {
            lps.set(i, !lps.get(i));
        }

        // append lops ++ to Lp
        lp.add(lpos);
        lps.add(ups[lpos - 1] == 'U');

    }

    static void rFlip() {
        rpos--;

        // reverse Lp
        Collections.reverse(rp);
        Collections.reverse(rps);

        for (int i = 0; i < rps.size(); i++) {
            rps.set(i, !rps.get(i));
        }

        // append lops ++ to Lp
        rp.add(rpos);
        rps.add(ups[rpos - 1] == 'U');
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

        public char nextChar() throws IOException {
            int c = reader.read();
            return (char) c;
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }
    }
}



