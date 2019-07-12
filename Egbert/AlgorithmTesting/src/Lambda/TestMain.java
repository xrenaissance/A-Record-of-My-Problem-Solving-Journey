package Lambda;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
public class TestMain {
    private static final List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        GreetingService HiService = new GreetingService() {
            @Override
            public String greet(String fn, String ln, int age) {
                return  ("Hi, " + fn + " " + ln);
            }
        };
        GreetingService helloService = (fistName, lastName, age) -> {
            return new StringBuilder().append(fistName).
                                       append(" ").
                                       append(lastName).
                                       append(" ").
                                       append(age).toString();
        };
        test(helloService);
        test((fn, ln, age) -> fn.toLowerCase() + " " + ln.toUpperCase() + " " + age);

        // StringOperations sopt = System.out::println;
        // StringOperations sopt = Objects :: isNull;
        // StringOperations sopt = String :: toUpperCase;
        // System.out.println(sopt.accept("Tina"));
        StringOperations sopt = list :: add;
        sopt.accept("Tina");
        System.out.println(list);
        System.out.println();

        // Calculator
        MathOperation add = (a, b) -> {
            System.out.println("Addition: " + a + b);
            return a + b;
        };
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;
        calculate(add, 4, 5);
        System.out.println("Subtract: " + calculate(subtract, 4, 5));
    }
    private static int calculate(MathOperation opt, int a, int b) {
        return opt.operate(a, b);
    }
    private static void test(GreetingService g) {
        String returnedString = g.greet("Steven", "Zhou", 100);
        System.out.println(returnedString);
    }
}
