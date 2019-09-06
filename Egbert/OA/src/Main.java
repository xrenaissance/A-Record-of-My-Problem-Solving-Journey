import Amazon.RightRotation;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        String word1 = "hello";
        String word2 = "olleh";
        // "hellohello"
        System.out.println(RightRotation.rightRotate(word1, word2));
        List<String> res = ValidIfBlocks.validIf(3);
        printList(res);
    }
    public static void printList(List<String> res) {
        for (String str : res) {
            System.out.println(str);
        }
    }
}
