# [G] Core Java - Java8 features
Java 8 Concepts
Topics:

1. Functional Interface
2. Java 8 Core concepts
3. Lambda Expression
4. Predicate
5. Function
6. Consumer
7. Supplier
8. Streams API
9. Parallel Streams API
10. Collectors
11. Primitive Streams API

# Lambda Expression

- It is anonymous function, with no return type, no name, no access modifier
- Conciseness | Readability | support FP |

Code :

Runnable r1 = new Runnable(){
public void run(){
S.O.PL("");
}
};

Runnable r2 = ()->S.O.P();

new Thread(r1).start()
new Thread(r2).start();

# Predicate


Predicate - functional Interface in java.util.function package that represents boolean valued function
It takes single argument and returns the boolean result

@FunctionalInterface
public interface Predicate<T>{
    boolean test(T t);
}

- test(T t) - evaluate predicate for the given argument t
- and
- or
- negate

Usage - filtering operation, validations, conditional logic

Code :

        Predicate<Integer> isEven = x -> x%2 ==0;
        Predicate<String> isStartsWithA = s -> s.startsWith("A");

        System.out.println(isEven.test(4));
        System.out.println(isStartsWithA.test("Alpha"));

        Predicate<String> startsWithA = s -> s.toUpperCase().startsWith("A");
        Predicate<String> endsWithT = s -> s.toLowerCase().endsWith("t");

        Predicate<String> andPredicate = startsWithA.and(endsWithT);
        System.out.println(andPredicate.test("Ankit"));


# Function 


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

# Consumer 


/*
Consumer - functionalInterface with method .accept()
Predicate - .test()
Function - .apply()
Consumer - .accept()
- It consumes something , but not provide any output
*/

import java.util.function.Consumer;
import java.util.List;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	
	Consumer<Integer> consumer = x -> System.out.println(x);
	consumer.accept(5);
	
	List<Integer> list = Arrays.asList(1,2,3);
	Consumer<List<Integer>> printList = x -> {
	    for(int i: x){
	        System.out.println(i);
	    }
	};
	printList.accept(list);
		
		
	}
}

# Supplier


/*
Supplier - only supply Data
.get() 

predicate - .test()
consumer - .accept()
function - .apply()
supplier - .get()
*/

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	
	 Supplier<String> giveHelloWorld = () -> "Hello World";
	 System.out.println(giveHelloWorld.get());
		
	}
}

# Streams 

/*
Streams API - we can process collections of data in a functional and declarative manner

Streams is divided into 3 parts
1. source
2. intermediate operations
3. terminal opaeration


Stream - a sequence of elements supporting functional programming
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class Main
{
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		Stream<Integer> stream = numbers.stream();
		
		long count = numbers.stream().filter(n -> n%2 == 0).count();
		System.out.println(count);
		
		
		/*
		Creating Streams [from list,arrays | from .of() | .generate() |.iterate()]
		
		//way-1 : from collections 
		//list.stream()
		
		//way-2 : from arrays 
		String[] arrays = {"apple","banana","cherry"};
        Stream<String> stream1 = Arrays.stream(arrays);
        
        //way 3: Using .of() method 
        Stream<String> stream2 = Stream.of("a","b");
        
        //way-4 : using .generate() method
		Stream<Integer> stream3 = Stream.generate(()->1).limit(100);
		stream3.forEach(i -> System.out.println(i));
		
		//way-5 : using .iterate method 
		Stream.iterate(1, x)
		
		*/
		
		
		//Intermediate Operations 
		
		List<String> list1 = Arrays.asList("a","b","c","ac","aa","ab");
		
		List<String> generate = list1.stream()
		.filter(x -> x.startsWith("a"))
		.map(x -> x.toUpperCase())
		.collect(Collectors.toList());
		
		
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5);
		int sum = intList.stream().reduce((x,y)->x+y).get();
		
		
		String sentence = "Hello World";
		IntStream chars = sentence.chars();
		
		long count1 = sentence.chars().filter(x -> x == 'o').count();
		System.out.println(count1);
			
		
	}
}
