package Facebook;
import java.util.Set;
import java.util.HashSet;

/**
 * @leetcode https://leetcode.com/problems/goat-latin/
 * @Time N
 * @Space N + N ^ 2
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder postfix = new StringBuilder();
        String vowels = "aeiouAEIOU";
        Set<Character> vowelSet = new HashSet<>();
        for (int i = 0; i < vowels.length(); i++) {
            vowelSet.add(vowels.charAt(i));
        }

        postfix.append('a');
        for (String word : S.split(" ")) {
            transfering(word, postfix, result, vowelSet);
            postfix.append('a');
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private void transfering(String word, StringBuilder postfix,
                             StringBuilder result, Set<Character> vowelSet) {
        if (vowelSet.contains(word.charAt(0))) {
            result.append(word);
        } else {
            result.append(word.substring(1))
                    .append(word.charAt(0));
        }

        result.append("ma").append(postfix.toString()).append(" ");
    }

    // Solution 2
    public String toGoatLatinSol2(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder postfix = new StringBuilder();
        postfix.append('a');

        for (String word : S.split(" ")) {
            transferingSol2(word, postfix, result);
            postfix.append('a');
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private void transferingSol2(String word, StringBuilder postfix,
                             StringBuilder result) {
        if (startsVowel(word.charAt(0))) {
            result.append(word);
        } else {
            result.append(word.substring(1))
                    .append(word.charAt(0));
        }

        result.append("ma").append(postfix.toString()).append(" ");
    }

    private boolean startsVowel(char letter) {
        letter = Character.toLowerCase(letter);
        return letter == 'a' || letter == 'e' || letter == 'i'
                || letter == 'o' || letter == 'u';
    }
}
