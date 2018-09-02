/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadSafety;


public class ThreadSafetyExample_1 {
    
    public static void main(String[] args) throws InterruptedException {
        
        Counter counter = new Counter();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100000 ;i ++)
                        counter.increment();
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100000 ;i ++)
                {
                         counter.increment();
                    

                }
                

            }
        });
        
        
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100000 ;i ++)
                {
                         counter.Decrement();
                    
                }
                

            }
        });
        
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000 ;i ++)
                {
                       System.out.println("Value is : "+counter.get());
                }
                

            }
        });
        
        t1.start();
        t2.start();
        
      t3.start();
       //t4.start();
        
       
        t1.join();
        t2.join();
        t3.join();
        
       System.err.println("Value is "+counter.get());
    
    }
}
