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



