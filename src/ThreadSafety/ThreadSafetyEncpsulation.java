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
public class ThreadSafetyEncpsulation {
    
    
    public static void main(String[] args) throws InterruptedException {
    
        ClassA a = new ClassA();
        ClassC c = new ClassC();
        
        c.Method4();
        a.Method1();
        
         
        
    }
    
}
