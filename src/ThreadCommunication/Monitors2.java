/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadCommunication;

/**
 *
 * @author dileepa
 */
public class Monitors2 {
    
    
    private Object monitor = new Object();
    private int resource = 0;
    private boolean updated = false;
    
    public void method1() throws InterruptedException
    {
        synchronized(monitor)
        {
            if(updated)
            {
                System.out.println(" Method 1 : Say Wait! ");
                monitor.wait();
            }
            
            System.out.println(" Method 1 : Just Updated! ");
            resource ++;
            updated = true;
            System.out.println(" Method 1 : Say Notify! ");
            monitor.notify();
            
     
        }
    }
    
     public void method2() throws InterruptedException
    {
         synchronized(monitor)
        {
            
            if(!updated)
            {
                System.out.println(" Method 2 :  Say Wait! ");
              monitor.wait();
            }
            System.out.println("Value of Resouce : "+ resource);
            updated = false;
            System.out.println(" Method 2 : Say Notify! ");
            monitor.notify();
        }
    }
    
   
}
