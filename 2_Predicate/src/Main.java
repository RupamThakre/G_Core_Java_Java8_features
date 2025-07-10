
/*
//Predicate - functional Interface in java.util.function package that represents boolean valued function
// It takes single argument and returns the boolean result
@FunctionalInterface
public interface Predicate<T>{
    boolean test(T t);
}
- test(T t) - evaluate predicate for the given argument t
- and
- or
- negate

Usage - filtering operation, validations, conditional logic
*/

import java.util.function.*;

public class Main
{
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x%2 ==0;
        Predicate<String> isStartsWithA = s -> s.startsWith("A");

        System.out.println(isEven.test(4));
        System.out.println(isStartsWithA.test("Alpha"));

        Predicate<String> startsWithA = s -> s.toUpperCase().startsWith("A");
        Predicate<String> endsWithT = s -> s.toLowerCase().endsWith("t");

        Predicate<String> andPredicate = startsWithA.and(endsWithT);
        System.out.println(andPredicate.test("Ankit"));
    }
}