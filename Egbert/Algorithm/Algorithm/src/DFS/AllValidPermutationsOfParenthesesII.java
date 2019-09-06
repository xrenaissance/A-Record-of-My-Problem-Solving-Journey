package DFS;
import java.util.List;
import java.util.ArrayList;
public class AllValidPermutationsOfParenthesesII {
    // Assumption: l,m,n >= 0
    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sol = new StringBuilder();
        validParentheses(l, m, n, 0, 0, 0, 0, 0, 0, sol, result);
        return result;
    }
    private void validParentheses(int l, int m, int n,
                                  int lLeft, int lRight,
                                  int mLeft, int mRight,
                                  int nLeft, int nRight,
                                  StringBuilder sol,
                                  List<String> result) {
        if (lRight == l && mRight == m && nRight == n) {
            result.add(sol.toString());
            return;
        }
        if (lLeft < l) {
            // add '('
            sol.append('(');
            validParentheses(l, m, n, lLeft + 1, lRight, mLeft, mRight, nLeft, nRight, sol, result);
            sol.deleteCharAt(sol.length() - 1);

            // don't add '('
            //validParentheses(l, m, n, lLeft, lRight, mLeft, mRight, nLeft, nRight, sol, result);
        }
        if (lRight < lLeft) {
            sol.append(')');
            validParentheses(l, m, n, lLeft, lRight + 1, mLeft, mRight, nLeft, nRight, sol, result);
            sol.deleteCharAt(sol.length() - 1);
        }
        if (mLeft < m) {
            // add '<'
            sol.append('<');
            validParentheses(l, m, n, lLeft, lRight, mLeft + 1, mRight, nLeft, nRight, sol, result);
            sol.deleteCharAt(sol.length() - 1);

            // don't add '<'
            //validParentheses(l, m, n, lLeft, lRight, mLeft, mRight, nLeft, nRight, sol, result);
        }
        if (mRight < mLeft) {
            sol.append('>');
            validParentheses(l, m, n, lLeft, lRight, mLeft, mRight + 1, nLeft, nRight, sol, result);
            sol.deleteCharAt(sol.length() - 1);
        }
        if (nLeft < n) {
            // add '{'
            sol.append('{');
            validParentheses(l, m, n, lLeft, lRight, mLeft, mRight, nLeft + 1, nRight, sol, result);
            sol.deleteCharAt(sol.length() - 1);

            // don't add '{'
            //validParentheses(l, m, n, lLeft, lRight, mLeft, mRight, nLeft, nRight,sol, result);
        }
        if (nRight < nLeft) {
            sol.append('}');
            validParentheses(l, m, n, lLeft, lRight, mLeft, mRight, nLeft, nRight + 1, sol, result);
            sol.deleteCharAt(sol.length() - 1);
        }
    }
}
