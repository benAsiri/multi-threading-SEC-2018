package CreatingThreads;

public class Practice1 {
	 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Created by implementing runnable Interface
        Thread t1 = new Thread(new Task1());
        //Created by Extending Thread Class
        Thread t2 = new Thread(new Task2());
        Thread t4 = new Thread(Practice1.task4);
        
        t1.start();
        t2.start();
        
        //Anonomous Class and Methods
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                
                      for(int i=10 ; i >-10; i--)
            {
                System.out.println("Run from Task 3 :"+i);
            }      
            }
        });        
        t3.start();
        t4.start();        
        //Lambda Expression       
       
    }
    
     public static Runnable task4 = () ->{
          for(int i=10 ; i >-10; i--)
            {
                System.out.println("Run from Task 4 : *");
            }      
        };
   
   
}
