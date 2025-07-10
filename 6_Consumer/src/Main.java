
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