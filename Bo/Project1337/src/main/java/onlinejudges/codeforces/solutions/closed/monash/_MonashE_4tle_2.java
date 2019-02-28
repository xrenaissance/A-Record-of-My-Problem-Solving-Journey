//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class _MonashE_4tle_2 {
//    public static void solution(BufferedReader reader, PrintWriter out)
//            throws IOException {
//        In in = new In(reader);
//
//        int n = in.nextInt(), m = in.nextInt();
//
//        List<Integer>[] ad = new List[n];
//        List<Integer> unvisited = new ArrayList<Integer>();
//        List<Integer> indegrees = new ArrayList<Integer>();
//        List<Integer> processing = new ArrayList<Integer>();
//        List<Integer> result = new ArrayList<Integer>();
//
//        // init ad + indegrees
//        for (int i = 0; i < n; i++) {
//            ad[i] = new ArrayList<Integer>();
//            unvisited.add(i);
//            indegrees.add(0);
//        }
//
//        // read in + calc indegrees
//        for (int i = 0; i < m; i++) {
//            int u = in.nextInt(), v = in.nextInt();
//            ad[u].add(v);
//            indegrees.set(v, indegrees.get(v) + 1);
//        }
//
//        boolean exec = true;
//
//        while (exec) {
//            exec = false;
//            // take "indegree = 0"s away
//            for (int i = 0; i < unvisited.size(); i++) { // i = index of "unvisited" queue
//                if (indegrees.get(i).equals(0)) {
//                    processing.add(unvisited.get(i));
//                    unvisited.remove(i);
//                    i--;
//                    exec = true;
//                }
//            }
//
//            // process
//            for (int i : processing) {
//                result.add(i);
//
//                for (int x : ad[i]) {
//                    indegrees.set(x, indegrees.get(x) - 1);
//                }
//            }
//            processing.clear();
//        }
//
//        if(unvisited.size() != 0){
//            out.print("-1");
//        } else {
//            out.print(result.get(0));
//            for (int i = 1; i < n; i++)
//                out.print(" " + result.get(i));
//            out.print("\n");
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                System.in));
//        PrintWriter out = new PrintWriter(new BufferedWriter(
//                new OutputStreamWriter(System.out)));
//        solution(reader, out);
//        out.close();
//    }
//
//    protected static class In {
//        private BufferedReader reader;
//        private StringTokenizer tokenizer = new StringTokenizer("");
//
//        public In(BufferedReader reader) {
//            this.reader = reader;
//        }
//
//        public String next() throws IOException {
//            while (!tokenizer.hasMoreTokens())
//                tokenizer = new StringTokenizer(reader.readLine());
//            return tokenizer.nextToken();
//        }
//
//        public int nextInt() throws IOException {
//            return Integer.parseInt(next());
//        }
//
//        public double nextDouble() throws IOException {
//            return Double.parseDouble(next());
//        }
//
//        public long nextLong() throws IOException {
//            return Long.parseLong(next());
//        }
//    }
//}
//
//
//
