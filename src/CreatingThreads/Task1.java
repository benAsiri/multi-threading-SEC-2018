package CreatingThreads;

public class Task1 implements Runnable{

    @Override
    public void run() {
       
        for(int i=0 ; i <10; i++)
        {
            System.out.println("Run from Task 1 :"+i);
        }
    }

}
