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
public class Counter {
    
    private Object mutext = new Object();
    private int i = 0;
    private int j = 100000;
    
    
    public int get()
    {
        
       //return i;  //Un comment this and see what happen 
        
        synchronized(mutext) // Comment then when uncomment above
        {
            //System.out.println(j);
            return i;
            
        }
    }
    
    public void increment()
    {
       // i++; //Un comment this and see what happen
        
        synchronized(mutext) // Comment then when uncomment above
        {
            i++;
            //j--;
        }
    }
    
    
    public void Decrement()
    {
       // i++; //Un comment this and see what happen
        
        synchronized(mutext) // Comment then when uncomment above
        {
            j--;
        }
    }
    
    
    
}
