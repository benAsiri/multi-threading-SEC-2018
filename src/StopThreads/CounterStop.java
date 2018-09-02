package StopThreads;

public class CounterStop implements Runnable{
    
    public void run(){
        
        Thread theThread = Thread.currentThread();
        
        try{
            
            for(int i=0;i<100000;i++)
            {
                //If the i value is grater than 10000 lets stop this thread !
                if(i>10000)
                {
                    theThread.interrupt();
                }
                    
                
                //Check weather the thread has interrupted !
                if(theThread.isInterrupted() )
                {
                     System.out.println("Thread has Interruped !");
                    throw new InterruptedException();
                }
                
                System.out.println("Current value of i : "+i);
            }
        }
        catch(InterruptedException e) {
            System.err.println(e.getMessage());
        }
        
        
    }
    
}
