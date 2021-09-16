## Java Multithreading, Concurrency & Performance Optimization Course
### Fundamental
Creation and coordination concepts.
- Daemon threads: Threads that run in the background.
- Join method: Allows one thread to wait until another thread completes its execution.
- Sleep method: Tells the operating system to not schedule the thread until the specified time passes.
- Thread interruptions: Handled by InterruptedException and interrupts a thread prematurely whatever is its state.

### Optimization
- In how many pieces shall we break a task down to achieve optimal concurrency? Can we breack any task into subtasks? Does this approach come for free?
- ThreadPool technique (HTTP server implementation)
- Improve the throughput in an application:
   - Breaking the into subtasks.
   - Running tasks in parallel.

### Data Sharing
- Stack memory: Memory region where all methods are executed
   - All vars belong to the thread executing on that stack.
   - The thread is statically allocated when it's created.
   - Stack's size is fixed.
   - Too deep hierarchy leads to stack overflow exception
- Heap: Shared memory region that belongs to the process. All the threads share whatever is in the heap.
  - Managed by Garbage Collector.
  - Objects stay as long as we have a reference to them
  - Statics vars stay forever (life cycle of the process)

### Concurrency
- Monitor: Synchronized methods that prevent any other thread access **any** of them until it's done. It means, this approach blocks the **object** for the thread that is currently executing it.
- Lock: Dedicated synchronized piece of code. The less code is in the synchronized block, the more code is running concurrently.
- Atomic operations and *volatile* keyword
- Race conditions and data races

### Locking Strategies & Deadlocks
- Coarse grain strategy vs Fain grain strategy
- Deadlock: When every thread wants to move forward but cannot bvecasue they are actually waiting for another one.
  - Mutual exclusion: Only one thread can have exclusive access to a resource.
  - Hold and wait: At least one thread is holding a resoource and waiting for another resource.
  - Non-preventive allocation
  - Circular wait (Solution: Enforce a strict order in lock acquisition).
  - Strategies:
      - Reentrant Lock: Verbose, complex and flexible.
      - Reentrant tryLock: Sensitive to interruptions good choice for watchdog.
      - ReentrantReadWrite Lock: Ideal choice for multiple readers attempt scenario.


Situation| ReentrantLock | tryLock | ReentrantReadWrite
---------|---------------|---------|----------------------
Thread accessing a shared resource| block thread | returns false | Depends on the type of the operation (w/r)
Many threads accessing a write method| just one | just one | just one
Many threads accessing a read method| just one,| just one| Many threads since it's guaranteed with read lock

### Communication
- Producer-Consumer technique
- Semaphore: Restricts the number of allowed users per critical section.
- Internal method of each object:
  - wait() : The current thread waint until another thread wakes it up. In the wait state is not consuming any CPU.
  - notify(): Wakes up a **single** thread waiting on that object.
  - notifyAll(): Wakes up all the threads waiting on that object.

### Communication
- Drawbacks of locks
   - As they increase, so do the chances to get deadlocks.
   - Slow critical section
   - Cycle waits (i.e. priority inversion).
- Introduction to _AtomicInteger_ : Only we need atomic operations. The [techniques](https://github.com/Luisa13/Algorithms/tree/main/Algorithms/Threads/MultiThreading/techniques) package implements two exercises using this approach.
- Even if each individual operation on each variable is atomic, the aggregate operation is not, where can be seen in the [product reviews exercise](https://github.com/Luisa13/Algorithms/blob/main/Algorithms/Threads/MultiThreading/advance/ProductReviews.java).
   
