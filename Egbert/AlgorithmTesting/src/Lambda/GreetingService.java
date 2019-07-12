package Lambda;
// SAM - single abstract method

@FunctionalInterface
public interface GreetingService {
    public String greet(String firstName, String LastName, int age);
}
