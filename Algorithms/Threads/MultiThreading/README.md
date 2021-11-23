# Java Multithreading, Concurrency & Performance Optimization Course
This course help you to build well designed & correct multithreaded applications in Java as well as gain expert-level practical knowledge of modern software architecture & low level programming using Threads. [Syllabus](https://www.udemy.com/course/java-multithreading-concurrency-performance-optimization/learn/lecture/11200012#overview)

Designed and delivered by _Michael Pogrebinsky_

## 1. Introduction
- Motivation and Operating System fundamental

## 2. Fundamental
- Thread Creation:
  - Extends Thread class
  - Implement Runnable and pass it to constructor of thread class
- [X] Exercise: [MultiExecutor](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/fundamentals/MultiExecutor.java)

## 3. Thread Coordination 
Creation and coordination concepts.
- Thread termination & Daemon threads
- Daemon threads: Threads that run in the background.
- Join method: Allows one thread to wait until another thread completes its execution.
- Sleep method: Tells the operating system to not schedule the thread until the specified time passes.
- Thread interruptions: Handled by InterruptedException and interrupts a thread prematurely whatever is its state.
- [X] Exercise: [Multithread Calculation](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/coordination/PowerBase.java)

## 4. Performance Optimization
- In how many pieces shall we break a task down to achieve optimal concurrency? Can we breack any task into subtasks? Does this approach come for free?
- ThreadPool technique (HTTP server implementation)[[1]](#1)
- Improve the throughput [[2]](#2) in an application:
   - Breaking it into subtasks.
   - Running tasks in parallel.
- [X] Example: [Image Procesing](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/optimization/ImageProcessor.java)
- [X] Example: [HTTP Server](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/optimization/HTTPServer.java)

## 5. Data Sharing between Threads
- Stacks and Heap memory regions
- Stack memory: Memory region where all methods are executed
   - All vars belong to the thread executing on that stack.
   - The thread is statically allocated when it's created.
   - Stack's size is fixed.
   - Too deep hierarchy leads to stack overflow exception
- Heap: Shared memory region that belongs to the process. All the threads share whatever is in the heap.
  - Managed by Garbage Collector.
  - Objects stay as long as we have a reference to them
  - Statics vars stay forever (life cycle of the process)

## 6. Concurrency
- Monitor: Synchronized methods that prevent any other thread access **any** of them until it's done. It means, this approach blocks the **object** for the thread that is currently executing it.
- Lock: Dedicated synchronized piece of code. The less code is in the synchronized block, the more code is running concurrently.
- Atomic operations and *volatile* keyword. 
     - **Volatile**[[3]](#3): Set shared variable to volatile to avoid caching between threads and guarantees that any thread will read the most recent written values.
- Race conditions and data races
- [X] Exercise: [Min Max metric](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/concurrency/MinMaxMetrics.java)
- [X] Exercise: [Trains intersection](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/concurrency/Trains.java)
- [X] Example [Data Races](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/concurrency/DataRace.java)
- [X] Example: [Atomic Operations](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/concurrency/AtomicOperations.java)

## 7. Locking Strategies & Deadlocks
- _Coarse grain_ strategy vs _Fain grain_ strategy
- Deadlock: When every thread wants to move forward but cannot becasue they are actually waiting for another one.
  - Mutual exclusion: Only one thread can have exclusive access to a resource.
  - Hold & wait: At least one thread is holding a resource and waiting for another resource.
  - Non-preventive allocation
  - Circular wait (Solution: Enforce a strict order in lock acquisition).
  - Strategies:
      - Reentrant Lock: Verbose, complex and flexible.
      - Reentrant tryLock: Sensitive to interruptions good choice for watchdog.
      - ReentrantReadWrite Lock: Ideal choice for multiple readers attempt scenario.
      
  - [X] Example (Reentrant ReadWrite Lock and Database): [Item Inventory](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/advance/ItemInventory.java)
  - [X] Exercise: [Product Review Service](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/advance/ProductReviews.java)
  

Situation| ReentrantLock | tryLock | ReentrantReadWrite
---------|---------------|---------|----------------------
Thread accessing a shared resource| block thread | returns false | Depends on the type of the operation (w/r)
Many threads accessing a write method| just one | just one | just one
Many threads accessing a read method| just one,| just one| Many threads since it's guaranteed with read lock

## 8. InterThread Communication
- Producer-Consumer technique
- Learn the [difference between](https://stackoverflow.com/questions/2332765/what-is-the-difference-between-lock-mutex-and-semaphore?noredirect=1&lq=1) lock , mutex and semaphore [[4]](#4)
- Semaphore: Restricts the number of allowed users per critical section.
- Internal method of each object:
  - wait() : The current thread waint until another thread wakes it up. In the wait state is not consuming any CPU.
  - notify(): Wakes up a **single** thread waiting on that object.
  - notifyAll(): Wakes up all the threads waiting on that object.
- [X] Exercises: [exercises](https://github.com/Luisa13/Algorithms/tree/main/Algorithms/Threads/MultiThreading/communication)

## 9. Lock Free Algorithms, Data Structures & Techniques
- Introduction to non-blocking, Lock-free operations.
- Drawbacks of locks
   - As they increase, so do the chances to get deadlocks.
   - Slow critical section
   - Cycle waits (i.e. priority inversion).
- Introduction to _AtomicInteger_ : Only we need atomic operations. 
- Atomic references, compare and set, Lock Free high performance  data-structure
- Even if each individual operation on each variable is atomic, the aggregate operation is not, where can be seen in the [product reviews exercise](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/advance/ProductReviews.java).
- [X] Exercises: [exercises](https://github.com/Luisa13/Algorithms/tree/main/Algorithms/Threads/MultiThreading/techniques)
   

</br>

</br>

</br>

CONCEPTS:

<a id="1">[1]</a> 
**Thread Pooling** is a technique where we can improve the throughput by N (where N != threads != cores) by serving each task on a different thread in parallel with a fixed number of threads. If the pool is performing a blocking call means that not all the threads will be in running state, so the formula _threads = cores_ does not apply this time.

<a id="2">[2]</a> 
**Throughput**: The number of tasts completed in a given period. It can be improved by breaking the main task into subtasks and/or running tasks in parallel.

<a id="3">[3]</a> 
**Volatile**: It is a keyword used to set that a variable will not be cached between threads guaranteeing that any thread will read the most recent written values. It might be used to set an order between operations since also has the memory-effect of introducing a happens-before relationship ([more here](https://stackoverflow.com/questions/2441279/volatile-guarantees-and-out-of-order-execution))

<a id="4">[4]</a> 
Mutexes allows only one thread accesses to the critical section. They are more like a theoretical concept, and might be implemented using ReentrantLock or Semaphores.


OTHERS REFERENCES:
- [Difference between atomic and volatile](https://medium.com/javarevisited/difference-between-atomic-volatile-and-synchronized-in-java-fa3c9d445828)
- [Synchronization in Java](https://levelup.gitconnected.com/synchronization-in-java-all-you-need-to-know-7bd27219ce10)
- [Threads in a nutshell](https://mbavatharany.medium.com/threads-in-java-part1-7f01e45a9248)
- [Improve Java application performance (soft)](https://topdeveloperacademy.com/articles/top-3-tips-to-improve-your-java-applications-performance)
