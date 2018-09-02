Multi-threading-SEC-2018

## In Breif About How Multi Threading Work.
Multithreading is a practice of having multiple tasks running in the same program at the same time concurrently to do it efficiently. It can give us to access to more computing resources. The focus is to give more parallel computing resources as much. But to achieve this not only hardware is enough but the software needs to provide multithreading capabilities. 

Even single threading can do implement the functional requirements but if the single threading system needs to schedule many different tasks it can be queue them up and then only can execute on by one. 

However, let’s say one task in the queue is taking lot more time to complete the task other task can be affected at that delay. So, there is a performance coupling in the system where the performance of any one part can affect every other part. However, in multithreading system task scheduling is handled by the operating system. If the tasks are divided into separated threads since all threads are running parallel even if one task in a different thread is waiting other task don’t want to wait till its completing.

## Revision 1

- Having multithreading is the code is executing at multiple points of execution
concurrently.

- But all these are separated it’s not always separated because sometimes you may need
to share some resources in between separated threads. So, this could lead to a serious
issue in multithreading where the race conditions is coming to the picture.

- Race condition is happing when you have shared a resource with in multiple threads. So
when one thread is reading other thread can write to the resource simultaneously. The
effect of this are essentially random and unpredictable, because the threads are busy
violating each other’s assumptions.

- To avoid race conditions, we can use a resource locking mechanism. A mutex or
semaphors can be used for this. What it does ? when accessing resource by one thread
it needs to lock the resource and while that thread is using the resource other threads
cant access it. When the thread finish using the resource it can release the resource by
unlocking.

- Even locking can solve the problem of race condition there is another problem coming
to the picture, that is the big bad boy deadlock. If two or more resources locking a
resource and each other are waiting for each other to unlock the resource there can be
a deadlock.

- But to avoid race condition there is a mechanism called rollback. If for a one thread the
resource is not available instead of simply waiting for it can be roll back any changes
made so far. But this will lead to another problem called live lock. The code is
performing work – it is not simply waiting but no progress is being made.


## Threads & Languages

- Multithreading is implemented by the operating system itself, but different languages
have different levels of support for it.

- In python global interpreter lock is preventing, running multiple thread by the
interpreter. That means it blocks multithreading can will only allowed to run one thread
at a time. This essentially prevents the any performance gain by multi CPU’s.

- This is because we use the interpreter in Python. But in interpreted languages threads
don’t necessarily need the interpreter all the time, if they are performing IO operatings
like file reading /writing.

- In other implantations of python there is no GIL, Jython complies python code into JVM
code where are IronPython will convert the Python code to a .NET CLR code. In the both
cases there is no GIL or python interpreter lock.


## Threads & Languages

**Go through the Pacakge CreatingThreads in the project. There are three classes, One main
function called : Practice1 and two tasks : Task1, Task2 implemented in both ways.**

- A task is a code that to be executed with necessary data.

- A thread is a mechanism to execute the code in parallel.

- There are two ways to implement a tasks,
 - Extending the Thread Class: Template Method Pattern
 - Implementing the Runnable Interface: Strategy Pattern
 
- When you extend the Thread class you are losing so much of things with in that class.
Because Java is not supported to multiple inheritance you blocked the chance of
extending more of your classes.

- But by implementing runnable interface you gain the all control over you class where
you can use another class to extend it.

- When you do both, don’t forget the run() method which does all the stuffs in your task.

- Once you created the task you need to execute the task for that we need to create a
thread object and then pass the task as a constructor parameter to the thread object
and after we need to start the thread by calling the method called start() which contains
in the Thread class.


## Resource Sharing

**Go through the shared resources example Only One Class with imutable String**

- There are number of issues that will raise with threading when it comes to Resource
Sharing.

  - Race conditions
  - Deadlocks
  - Live Locks
  - Memory Synchronization issues
  
- Share resource could be an object, group of objects or even primitive field value.

- Sharing resource between threads and sharing resource between classes are two
different things.

- Resource sharing happens in runtime in threads.

- Can happen within a single class on its private fields.

- Resource is shared between threads, but there’s usually only one physical section of
code involved.

- If you have a immutable resource you don’t need to worry about it.

- Imitability is a highly desirable characteristic in multithreading.

- But it’s hard to use immutable resources hence threads need to communicate and
record result in a shared location.

- So because of that we need to create thread-safe mutable resources.

- Thread-safe mutable resource must have atomic operations. “Atomic” means literally
indivisible, that means two such operations cannot happen with that resource at the
same time.

- How to create thread-safety ? this can be done by locking resources.

- Not all the classes are thread-safe by default reason? Efficiency.

- Mutex is not a complicated object but locking and unlocking cost in processing time.

- If such object is not sharing then there is no point of locking and wasting CUP time.

- Immutable does not mean that a can never equal another value. 

For example, String is immutable too, but I can still do this:

```ruby

String str = "hello";
// str equals "hello"
str = str + "world";
// now str equals "helloworld"

```
So what happened there? Since **String** is immutable, clearly **str** was not changed.
But it now equals something different. This is because **str** is now a completely newly
instantiated object, just as your **Integer** is. So the value of a did not mutate, but it
was replaced with a completely new object, i.e. **new Integer(6)**


## How to create Thread-Safe Classes.

**Go through the Pacakge ThreadSafety in the project. There are two classes, One main function
called : ThreadSafetyExample_1 and Counter class .**

- To create thread-safety we need to you synchronized statement.

- Only one thread at a time can execute the contents of this synchronized statement.

- If there are other sync statements that share the same mutext object only one thread-can execute any of them at a time.

- **Mutex** is an object that works as a **mutual exclusion lock**. It is like a single key for a single
toilet. Only the person with the key can go to the toilet but one at a time can use the
toilet. You can share the toilet unless you have psychological issue ( which is a joke) :) 

- Mutext really don’t know what the resources actually is but it’s our job to keep track of-
that.

- In java **synchronized** keyword can be used as a method modifier but it is not always
good way to do it. Because it will lock the entire method for the duration of the
resource usage. But you might only need to lock and use the shared object in very little
part of the code. **Locking for longer than necessary is inefficient, because it will end up
blocking other threads for longer than necessary.**

- Instead of using a object of Object class we can simply pass the current object by
passing this keyword but it is not good practice at all. Because, this is effectively public
and anything else that has a reference to this object can use it as a mutex. If object itself
using as a mutex internally it might end up in a deadlock situation.

- If you want to lock multiple resources you need to use more than one mutex objects
and separate or nested synchronized statements.

- Encapsulation between threads classes should done as foolows:
 - Thread communication is the responsibility of one class
 - Start one thread and provide much of the code that this tread executes
 - Have a set of public accessors and mutators intended to be called by a different
   thread.
 - Contain the mutex and shared resource as private fields, that will allow these
   two threads to communicate.
   
- The implement and encapsulate works with multiple threads can be made as follows :

```ruby
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

```


## Memory Synchronization

- Synchronized statement does more than locking it also instruct the compiler to
synchronize the memory in which fields are stored. The fields used with in the blocks.

- Compilers don’t do what you instruct them raster they do something functionally similar
to what you instruct them,

- Some tricks that done by compiler: re-arrange the order of the instructions, removing
operations entirely if they have no effect, caching filed values in cpu registers.

- Registers are very faster than the RAM, but field values are officially stored at the RAM.
When you have operations which frequently read or write the field value, compiler may
choose to work with the value in the register.

- Using the cache is a valuable thing but there is a problem, that is by default complier
assumes that there is only one thread using this field.

- Even though without the synchronized keyword if the thread is accessing a field value
more times its cached.

- To avoid this caching we need to flag the field with volatile keyword. But remember that
volatile does not stop the race conditions or dead locks.

- To get the idea look at the following code block or refer to the Project Memorysync and
the **Counter.java class**

```ruby

public class Counter{

  private volatile int i=0;
  
  public int get(){
   return i;
  }

  public void increament(){
   i++;
   //here occours the race condition becuase we are not locking the resource for any threads
  }
}

```


##Threads Communication : Monitors

- Threads can communicate using a shared resource, but actual communication cost the
timing. Threads must be able to signal each other, so that one can tell another that
when the information is actually available.

- Earlier we used to create a Boolean flag to record the status of the resource availability
and then if the flat is true the other thread can start consuming it. This way we used to
communicate over two threads. But it is very in efficient and waste CPU time. Because if
the date looking for one thread is not available that thread need to wait for long time. It
better instead of simply waiting if it can go to sleep until the data is available.

- For this we use monitors, monitor is a mutex kind of thing. It has for basic operations,
wait(), notify(), lock(), unlock()

- Scenario A: Related to the Project Thread Communication use class Monitors + Main
Lets assume that the Thread 2 start first :
 - Thread 2 start first and then lock the resource (method2) with the monitor
object then it calls the wait() method and thread 2 goes to suspend state.


 - Thread 2 wait for the thread 1 to update the resource (method1)
 
 - Thread 2 still locked the monitor and it will release the lock
 
 - Thread 1 now lock the resource with monitor (if there are more than one
   threads we don’t know who is going to access it )
   
 - Now Thread 1 writes to the resource
 
 - Calling notify() method thread 1 notifies to the waiting thread 2 (if there are
   many other threads waiting monitor picks one of them and wake)
   
 - Now still Thread 1 has locked the monitor object
 
 - Thread 1 releases the lock and the thread 2 again locks the resource with
   monitor object thread 2 begins execution again.
   
 - Finally thread 2 unlocks thee resource
  
   - There are number of issues with this method :
     - If the method1 or the thread 1 runs first then the info is arrived to the
       resource and it was updated but thread 2 has to wait unnecessarily
     - If thread 1 updates the resource several times before thread 2 gets to it
       thread 2 will miss some information.

- Scenario B : Related to the Project Thread Communication use class Monitors2 + Main2
 - Same as the scenario A but you need to add a Boolean flag to check weather the
   resource has been updated.
 - When the thread runs it needs to check the resource has updated if not thread
   needs to wait() for the other thread to update it and once the update avil thread
   need to notify() it !
   
- So that we can guarantee that the both threads are at a known point in the code and
  know the state at the same time.
  

## Interrupting Threads
*Please go through the source code : StopThrad project*

- Don’t use stop() method to stop a thread use the interrupt() method.

- Stop() will throw ThreadDeath exception inside the thread if it is not caught it will close
  all currently running methods to end including the task’s main run() method.
  
- Its impossible to find where the ThreadDeath exception happens. It could be any where
  in the code.
  
- If ThreadDeath occurred while constructing or mutating an object which other threads
  are also used that object, that object can fall into unusable state and possibly an invalid
  state.

- Don’t never try to handle ThreadDeath

- Kindly stop the thread using interrupt() method

- When using interrupt() method there few things to remember :
  - Use Thread.isInterrupted() method to check the state
  - If There is any interruption exit from the thread by throwing new
    InterruptedExeption().

- Some other methods that throw InterruptedException()
  - Thread.sleep()
  - Object.wait()

- Java.io class don’t throw InterruptedException() this make it tricky to handle interrupts
  in a middle of a reading or writing to a file or sending or receiving data from network.

- For this we can use another set of new IO classes called java.nio which will throw
  ClosedByInterruptedException() which is a subclass of IOException

