/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadSafety;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dileepa
 */
public class RunningCounter implements Runnable {

    private Object mutex = new Object();
    private int resource =0;
    
    @Override
    public void run() {
        
        
        try {
            
            while(resource <1000)
            {
                    synchronized(mutex)
                    {
                         System.out.println(resource);
                    }
                      Thread.sleep(1000);
            }
          
        } catch (InterruptedException ex) {
            Logger.getLogger(RunningCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void increment()
    {
        synchronized(mutex)
        {
            resource ++;
        }
    }
    
    
    
}
