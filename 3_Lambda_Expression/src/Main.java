
// Implementing Runnable Interface using Lambda function

public class Main
{
    public static void main(String[] args) {

        //Traditional way
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("Runnable Interface 1");
            }
        };

        //Lambda
        Runnable r2 = () -> System.out.println("Runnable Interface 2");

        new Thread(r1).start();
        new Thread(r2).start();
    }
}