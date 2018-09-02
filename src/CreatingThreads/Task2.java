package CreatingThreads;

public class Task2 extends Thread{


    public void run() {
         for(int i=0 ; i <20; i++)
        {
            System.out.println("Run from Task 2 :"+i);
        }
    }
}