## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |      10,000,000    |  0.01446824998  |
| Using ReentrantLock     |      10,000,000    |  1.09786349998  |
| Synchronized method     |      10,000,000    |  0.5749805      |
| AtomicLong for total    |      10,000,000    |  0.294943       |

## 1. Using unsynchronized counter object

It not always zero because two thread not finish each state in the same time, so it makes not thread not done in the same time. Sometime, total will be zero if two thread finish the process in the same time.

## 2. Implications for Multi-threaded Applications

How might this affect real applications?  

## 3. Counter with ReentrantLock

3.1 The total always zero.
3.2 Because use a ReentrantLock for lock another thread to access the counter when the counter was used.
3.3 ReentrantLock will lock the counter when a thread1 use the counter so thread2 cann't access to the counter until the thread1 finish the state and unlock. And thread1 cann't access the counter when thread2 do an acqire. ReentrantLock would used when want to lock some statement in code.
3.4 Because we have to unlock the counter for another thread.

## 4. Counter with synchronized method

4.1 The total always zero and runtime less than use a reentrant lock.
4.2 Because use a synchronous for lock another thread to access the method when the method was used.
4.3 Synchronized will lock the method when thread do acqire and another thread cann't do a work in the same time. Synchronized would used when want to lock all statement in method.

## 5. Counter with AtomicLong
5.1 Because in AtomicLong class already thread safe.
5.2 AtomicLong make threads not use the same variable in the same time and we use it when in the class or program have all variables in type Long or Double or Integer.

## 6. Analysis of Results

6.1 AtomicLong for total is the fastest and Using ReentrantLock is the slowest.
6.2 Synchronized 

## 7. Using Many Threads (optional)

