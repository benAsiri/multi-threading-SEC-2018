/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadSafety;

/**
 *
 * @author dileepa
 */
public class ClassC {
    
    int i =0;
    Counter c = new Counter();
    
    public void Method4(){
        
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                c.increment();
                
                for(int j=0;j<100000;j++)
                {
                i++;
                }
                
                System.out.println("Output from Class C Method 4 : "+c.get());
            }
        });
       
        t.start();
    }
}
