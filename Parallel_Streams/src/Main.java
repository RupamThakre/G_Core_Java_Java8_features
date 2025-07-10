
/*
Parallel Streams - a type of stream that enables parallel processing of elemenes

let us suppose , I created a list of 20K data, now i want to perform the factorial of all those


*/
import java.util.List;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<Integer> list = Stream.iterate(1, x->x+1).limit(20000).toList();

// 		list.stream().map(Main::factorial).toList();

        list.parallelStream().map(Main::factorial).toList();

        long endTime = System.currentTimeMillis();

        System.out.println("Time Taken :"+(endTime - startTime)+ " ms");
    }

    private static long factorial(int n){
        long result =1 ;
        for(int i = 2; i<=n ;i++){
            result *= i;
        }
        return result;
    }
}