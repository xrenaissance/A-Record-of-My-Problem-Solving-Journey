package UnionFind;

import java.util.*;
public class ParentChild {
    public static void main(String[] args) {
        String input1 = "(A,B) (C,D) (A,C)";
        String input2 = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        System.out.println(ParentChild.GetSExpression(input1));
        System.out.println(ParentChild.GetSExpression(input2));
        System.out.println("----------------");
        String error1 = "(A,B) (A,C) (A,D)";
        String error2 = "(A,B) (A,B)";
        String error3 = "(A,B) (B,C) (C,A)";
        String error4 = "(A,B) (C,D)";
        String error5 = "(A,B) (B,C) (A,C)";
        String error6 = "(A,B) (C,B) (D,B)";
        String error7 = "(A,B) (B,C) (C,B)";
        System.out.println(ParentChild.GetSExpression(error1));
        System.out.println(ParentChild.GetSExpression(error2));
        System.out.println(ParentChild.GetSExpression(error3));
        System.out.println(ParentChild.GetSExpression(error4));
        System.out.println(ParentChild.GetSExpression(error5));
        System.out.println(ParentChild.GetSExpression(error6));
        System.out.println(ParentChild.GetSExpression(error7));
    }
    public static String GetSExpression(String str){
        boolean[][] graph = new boolean [26][26];
        HashSet<Character> nodes = new HashSet<>();
        //construct graph and check error E2: duplicate edges
        boolean E2 = false;
        char[] s = str.toCharArray();
        for(int i = 1; i < s.length; i += 6){
            int x = s[i] - 'A';
            int y = s[i + 2] - 'A';
            if (graph[x][y]) { //duplicate edge
                E2 = true;
            }
            graph[x][y] = true;
            nodes.add(s[i]);
            nodes.add(s[i + 2]);
        }
        //check error E1: more than 2 children
        boolean E1 = false;
        for(int i = 0; i < 26; i++){
            int count = 0; //number of child
            for(int j = 0; j < 26; j++){
                if(graph[i][j]) {
                    count++;
                }
            }
            if(count > 2) {
                return "E1";
            }
        }
        if (E2) {
            return "E2"; //return E2 after checking E1
        }

        //check E3: cycle present and E4: multiple roots
        int numOfRoots = 0;
        char root = ' ';
        for (char node : nodes){ //only check char that in the tree
            for(int i = 0; i < 26; i++){
                if(graph[i][node - 'A']) {
                    break;
                }
                if (i == 25){
                    numOfRoots++;
                    root = node;
                    boolean[] visited = new boolean[26];
                    if(IsCycle(node, graph, visited)) {
                        return "E3";
                    }
                }
            }
        }
        if (numOfRoots == 0) {
            return "E3"; //if no root, must be a cycle
        }
        if (numOfRoots > 1) {
            return "E4"; //if more than one roots
        }
        if (root == ' ') {
            return "E5"; //if no edge in input string, invalid input error
        }
        return GetExpressionHelper(root, graph);
    }

    //true means there is a cycle, false means no cycle
    private static boolean IsCycle(char node, boolean[][] graph, boolean[] visited){
        if(visited[node-'A']) { //node has already been visited, must has a cycle
            return true;
        }
        visited[node-'A'] = true;
        for (int i = 0; i < 26; i++){
            if (graph[node -'A'][i]){
                if (IsCycle((char)(i + 'A'), graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Recursive DFS to get the expression/construct the tree
    private static String GetExpressionHelper(char root, boolean[][] graph){
        String left = "";
        String right = ""; //if no children, left and right should be empty
        for (int i = 0; i < 26; i++){
            if(graph[root - 'A'][i]){
                left = GetExpressionHelper((char)(i + 'A'), graph);
                for(int j = i + 1; j < 26; j++){
                    if(graph[root - 'A'][j]){
                        right = GetExpressionHelper((char)(j + 'A') ,graph);
                        break;
                    }
                }
                break;
            }
        }
        return "(" + root + left + right + ")";
    }
}
