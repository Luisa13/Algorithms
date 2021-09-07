## Java Multithreading, Concurrency & Performance Optimization Course
#### Fundamental
Creation and coordination concepts.
- Daemon threads: Threads that run in the background.
- Join method: Allows one thread to wait until another thread completes its execution.
- Sleep method: Tells the operating system to not schedule the thread until the specified time passes.
- Thread interruptions: Handled by InterruptedException and interrupts a thread prematurely whatever is its state.

#### Optimization
- In how many pieces shall we break a task down to achieve optimal concurrency?
- ThreadPool technique
- Improve the throughput in an application:
Breaking the into subtasks or
Running tasks in parallel.

#### Data Sharing
- Stack memory: Memory region where all methods are executed
   - All vars belong to the thread executing on that stack.
   - The thread is statically allocated when it's created.
   - Stack's size is fixed.
   - Too deep hierarchy leads to stack overflow exception
- Heap: Shared memory region that belongs to the process. All the threads share whatever is in the heap.
  - Managed by Garbage Collector.
  - Objects stay as long as we have a reference to them
  - Statics vars stay forever (life cycle of the process)

#### Concurrency
- Monitor: Synchronized methods that prevent any other thread access **any** of them until it's done. It means, this approach blocks the **object** for the thread that is currently executing it.
- Lock: Dedicated synchronized piece of code. The less code is in the synchronized block, the more code is running concurrently.
- Atomic operations and volatile keyword
- Race conditions and data races

#### Locking Strategies & Deadlocks
-Coarse grain strategy vs Fain grain strategy
- Deadlock: When every thread wants to move forward but cannot bvecasue they are actually waiting for another one.
  - Mutual exclusion: Only one thread can have exclusive access to a resource.
  - Hold and wait: At least one thread is holding a resoource and waiting for another resource.
  - Non-preventive allocation
  - Circular wait (Solution: Enforce a strict order in lock acquisition).
  
- Reentrant lock
- Reentrant tryLock
- ReentrantReadWrite Lock

#### Communication
- Producer-Consumer technique
- Semaphore: Restricts the number of allowed users per critical section.
- Internal method of each object:
  - wait() : The current thread waint until another thread wakes it up. In the wait state is not consuming any CPU.
  - notify(): Wakes up a **single** thread waiting on that object.
  - notifyAll(): Wakes up all the threads waiting on that object.

