//import java.io.*;
//import java.util.*;
//
//public class _MonashE {
//
//    public static void solution(BufferedReader reader, PrintWriter out)
//            throws IOException {
//        In in = new In(reader);
//
//        int n = in.nextInt(), m = in.nextInt();
//
//        List<Integer>[] ad = new List[n];
//
//        List<Integer> indegrees = new ArrayList<Integer>();
//
//        List<V> unvisited = new ArrayList<V>();
//        List<Integer> result = new ArrayList<Integer>();
//
//        // init ad + indegrees
//        for (int i = 0; i < n; i++) {
//            ad[i] = new ArrayList<Integer>();
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
//        // Construct unvisited
//        for (int i = 0; i < n; i++) {
//            unvisited.add(new V(i, indegrees.get(i)));
//        }
//
//        Collections.sort(unvisited, new IndegreeComparator());
//
//        // new take away
//        while(unvisited.size() != 0 && unvisited.get(0).indegree == 0) {
//            V current = unvisited.get(0);
//            unvisited.remove(0);
//
//        }
//
//        /////
//        // take "indegree = 0"s away
//        for (int i = 0; i < n; i++) { // i = index of "unvisited" queue
//            if (indegrees.get(i).equals(0)) {
//                processing.add(unvisited.remove());
//            }
//        }
//
//        // process
//        for (int i : processing) {
//            result.add(i);
//
//            for (int x : ad[i]) {
//                indegrees.set(x, indegrees.get(x) - 1);
//                candidates.add(x);
//            }
//        }
//        processing.clear();
//        /////
//
//        // output
//        if (unvisited.size() != 0) {
//            out.printf("%d", -1);
//        } else {
//            out.printf("%d", result.get(0));
//            for (int i = 1; i < n; i++)
//                out.printf(" %d", result.get(i));
//            out.printf("%n");
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
//class V {
//    int id, indegree;
//
//    public V() {
//    }
//
//    public V(int v, int c) {
//        this.id = v;
//        this.indegree = c;
//    }
//}
//
//class IndegreeComparator implements Comparator<V> {
//    @Override
//    public int compare(V x, V y) {
//        return Integer.compare(x.indegree, y.indegree);
//    }
//
//}