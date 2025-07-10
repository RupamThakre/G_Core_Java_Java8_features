
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