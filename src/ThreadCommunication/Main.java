package ThreadCommunication;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args)
    {
        Monitors monitor = new Monitors();
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                
                    monitor.method1();
            }
        });
        
      
         Thread t2 = new Thread(new Runnable() {
      
            @Override
            public void run() {                
                
                try {
                    
                    monitor.method2();
                    
                } catch (InterruptedException ex) {
                    
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    
                }                       
                
            }
        });
         
        
     t1.start();
        t2.start();
           
    }
}
