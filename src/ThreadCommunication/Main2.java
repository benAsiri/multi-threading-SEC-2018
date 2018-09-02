/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadCommunication;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dileepa
 */
public class Main2 {
    
    public static void main(String[] args)
    {
        Monitors2 monitor = new Monitors2();
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                
                try {
                    monitor.method1();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
      
         Thread t2 = new Thread(new Runnable() {
      
            @Override
            public void run() {
                
                
                try {
                    
                    monitor.method2();
                    
                } catch (InterruptedException ex) {
                    
                    Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                       
                
            }
        });
         
           
        t1.start();
        t2.start();
        t1.interrupt();
     
    }
}
