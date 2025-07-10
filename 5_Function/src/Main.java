
/*
Function - functional interface, it takes one argument and returns a result
part of java.util.function package , widely used in functional programming with lambda
In case of predicate, predicate is only holding boolean conditions
But , function can perform some operations on it .

@FunctionalInterface
public interface Function<T,R>{
    R apply(T t);
}

- apply()
- .andThen()
- .compose()

*/
import java.util.function.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {
        Function<Integer, Integer> doubleIt = x -> x*2;
        Function<Integer, Integer> tripleIt = x -> x*3;
        System.out.println(doubleIt.apply(100));
        System.out.println(tripleIt.apply(100));

        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(doubleIt.compose(tripleIt).apply(20));

        //Example - 2
        List<String> words = Arrays.asList("apple","banana","cherry");
        Function<String,String> toUpperCase = String::toUpperCase;

        List<String> upperCaseLetters = words.stream()
                .map(toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseLetters);


    }
}