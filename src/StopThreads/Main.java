package StopThreads;

public class Main {
    public static void main(String[] args) {
   
        
        CounterStop cs = new CounterStop();
        
        Thread t1 = new Thread(cs);
        
        t1.start();
        
    }
   
}
