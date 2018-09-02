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
public class Monitors {
    
    
    private Object monitor = new Object();
    private int resource = 0;
    
    public void method1()
    {
        synchronized(monitor)
        {
            resource++;
              System.out.println(" Say Notify! ");
            monitor.notify();
            //If there are multiple thrads waiting for the resource 
            //monitor.notifyAll();
        }
    }
    
     public void method2() throws InterruptedException
    {
         synchronized(monitor)
        {
            System.out.println(" Say Wait ! ");
            monitor.wait();
            System.out.println("Value of Resouce : "+ resource);
        }
    }
    
   
}
