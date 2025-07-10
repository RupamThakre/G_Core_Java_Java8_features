
/*
Combined Exmaple : Predicate + Consumer + Function + Supplier
*/

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) {

        Predicate<Integer> intPredicate = x -> x%2 == 0;
        Function<Integer, Integer> functionPredicate = x -> x*x;
        Consumer<Integer> consumerPredicate = x -> System.out.println(x);
        Supplier<Integer> supplierPredicate = () -> 100;

        if(intPredicate.test(supplierPredicate.get())){

            consumerPredicate.accept(functionPredicate.apply(supplierPredicate.get()));

        }









    }
}