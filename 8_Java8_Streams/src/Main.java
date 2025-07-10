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

        System.out.println(generate);













    }
}