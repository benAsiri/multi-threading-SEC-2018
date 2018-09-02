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
public class ClassA {
    
    public void Method1(){
        
        Counter c = new Counter();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Output from Class A Method 1 : "+c.get());
                
            }
        });
       
        t.start();
    }
}
