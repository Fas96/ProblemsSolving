## COMMON OS RELATED INTERVIEW QUESTIONS

<i>In most common software interviews, you might come across few of the common related **Operating System(OS)** questions. Here is the list of some common questions that you might come across in your interview.
This list is curated from [leetcode](https://leetcode.com/discuss/interview-question/operating-system/3216693/INTRESTING-INTERVIEW-QUESTIONS-IN-OS) and few other sources.
As you know, **Operating system** is a vast topic and it is not possible to cover all the questions in one post. So, I will keep adding more questions to this list as I come across them.
Personally, I have not come across any of these questions in my interviews. But, I have seen these questions in other people's interviews. So, I thought of sharing this list will help people preparing for interviews 
like myself.</i>

<strong>NOTE: </strong> This post is study **summary & paraphrase** on various topic, that I have come across in my journey of learning. 

### **1.what is a kernel?**

The operating system's kernel is an essential component which controls **hardware and software functions**. </br>
In essence, it controls how memory and CPU time are used. <br>It is an essential part of the operating system. 
The kernel **serves as a link** between **software programs and hardware-level data processing** carried out through **system calls and inter-process communication**.

When an **operating system is loaded**, the kernel loads first and _stays in memory until the operating system is shut down_ once again. 
<br>It is in charge of several things, including **memory management**, **task management**, and **disk management**.

The process table in the kernel maintains track of all running processes.
• The region table for each process in the process table has an entry that refers to a region table entry.
• The region table entry has a pointer to the page table for the region.
<br>
It chooses which processes should be **retained in main memory for execution and which ones should be assigned to the processor for execution**. <br>
In essence, it serves as a **conduit between hardware and user programs**. The primary function of the kernel is to control communication between **user-level applications and hardware components like the CPU and disk memory.**
<br>
<br>
 <strong>Goals of the Kernel:</strong>
1. Create communication between hardware and user-level applications.
2. Determining the condition of incoming processes
3. Handle disk operations.
4. Manage memory.
5. Manage job completion.

##### **Types of Kernel :**
1. **Monolithic Kernel** : A monolithic kernel is a <b>single & large kernel</b> where  all operating system services operate in kernel space.<br> It has dependencies between systems components.<br> eg:<b> Unix, Linux, Open VMS, XTS-400 etc.</b>
2. **Micro Kernel** : The <b> minimalist approach </b>is used by kernel types. It has <b>thread scheduling and virtual memory</b>. With fewer services in the kernel area, it is more reliable.<b> Rest is provided in user space.</b><b> eg: Mach, L4, AmigaOS,Minix,K42, Exokernel etc.</b>
3. **Hybrid Kernel** : A combination of both monolithic and micro kernels. It has <b>speed and design</b> of monolithic kernel <b> & </b> <b> modularity and stability of microkernel</b>.<b> eg: Windows NT,Netware,BeOS,Plan9 etc.</b>
4. **Exo Kernel** : It is a <b>new type of kernel</b> which is <b>not monolithic or micro</b>. It is <b>modular</b> and <b>has a small core(fewest hardware abstractions as possible)</b>It follows end-to-end principle and also <b>allocates physical resources to applications</b>.<b> eg: Nemesis, ExOS etc.</b>
5. **Nano Kernel** : This particular kernel<b> lacks system services but provides hardware abstraction</b>. The Mini Kernel and Nano Kernel have become comparable since the Micro Kernel likewise lacks system services.<b> eg: EROS etc.</b>

<hr>


### **2.what is a bootstrap program?**
<b>Bootstrapping</b> is the process of loading a set of instructions when a computer is  <b> first turned on or booted.</b> <br>
**Diagnostic tests are run at startup**, such as the **power-on self-test (POST)**, to configure or check device settings and to carry out routine testing for **peripheral, hardware, and external memory device connections.** The System is then initialized by loading the **bootloader or bootstrap software.** <br>
##### **Programs that load the OS :** 
1. **GNU Grand Unified Bootloader(GRUB):** It is a <b>multiboot boot loader</b> that supports <b>multiple operating systems</b>. It is <b>open source</b> and <b>free software</b>. Which implies <b> A multiboot specification that allows the user to choose one of several OSs</b>.<br>
2. **NT Loader(NTLDR):** It is a <b>bootloader</b>  for <b>Microsoft’s Windows NT OS that usually runs from the hard drive</b>. 
3. **Linux Loader (LILO):** It is a <b>bootloader</b> for <b>Linux</b> that usually runs from the <b>hard drive</b> or floppy disc<br>.
4. **Network Interface Controller (NIC):** Uses a bootloader that supports booting from a network interface such as Etherboot or pre-boot execution environment(PXE).<br>

>> A computer is said to start with a blank main memory before booting. The boot-strap enables a series of applications to load in order to launch the OS. The operating system (OS) is the main program that controls all other programs that are running on a computer. It carries out functions like managing directories and files, controlling peripheral devices like a disc drive, sending output signals to a monitor, and recognizing input signals from a keyboard.

<br>

>> Bootstrap may also refer to the process of gradually transforming simpler programming environments into more complicated and user-friendly ones. An assembly program plus a basic text editor, for instance, may have been the programming environment in the past. The advanced object-oriented programming languages and graphical integrated development environments of today are the result of decades of incremental advancements (IDEs).


<hr>

### **3.what is the difference between the kernel and operating system?**
<b>Operating System (OS)</b> is a system program that **enables communication between a user and a computer**. When a computer is turned on, **Operating System is the first program to load**.<br>
<strong>The kernel </strong>is the <b>main element of an Operating System</b> and is also a system program. It is the part of the <b>Operating System that interprets user commands into machine language.</b><br>

| **Operating System**                                                                                       | **Kernel**                                                                               |
|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| OS is a system software                                                                                    | Kernel is a system software which is part of the OS                                      |
| OS provides interface between the user and hardware.                                                       | Kernel provides an interface between application and hardware.                           |
| It also provides protection and security                                                                   | Main purpose is memory management,disk management,process management and task management |
| All system needs operating system to run                                                                   | All operating systems need kernel to run                                                 |
| Types of operating system includes single and multiuser OS, multiprocessor OS,Realtime OS, Distributed OS. | Type of kernel includes Monolithic and Micro kernel.                                     |
| First program to load when the computer boots up.                                                          | First program to load when operating system loads.                                       |

<br>
<hr>

### **4.can a system run without OS?**

<b>YES. </b><br>
Although it seems impossible that a computer would not **exist without an operating system**, the truth is that **early computers did not exist**. They were just big machines tasked with one program at a time. In contrast, modern computers have to perform many different tasks, often simultaneously, **so without an operating system a laptop wouldn't really work.**

### **5.what sockets do hackers use?**
**Hackers employ particular sockets or ports.** Hackers may utilize any open ports or sockets in addition to a variety of tools and techniques to **gain unauthorized access to a system or network.** It's important to note that some ports and sockets, **like port 80 for HTTP traffic, port 443 for HTTPS traffic, and port 22 for SSH traffic,** are more frequently targeted by hackers. <br>

### **6.what is a mutex lock?**
A **mutex lock(mutual exclusion)** is a **synchronization mechanism** that allows **only one thread** to access a **critical section** of code at a time. <br>
**Critical section** is a **portion of code** that **accesses shared resources**. <br> 
In a **multi-threaded environment**, **multiple threads** can **access the same critical section** at the same time. <br>
**Mutex lock** is a **mechanism** that **prevents multiple threads** from **accessing the same critical section** at the same time. <br>
Example: <br> database access, file access,input-output devices,network connections etc. <br>
1. **A simple code example of unexpected behavior when a mutex lock is not used in java referenced from baeldung.com can be seen below:** <br>
```java
public class SequenceGenerator {

    private int currentValue = 0;

    public  int getNextSequence() {
        currentValue = currentValue + 1;
        return currentValue;
    }


     Set<Integer> getUniqueSequences(SequenceGenerator generator, int count) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            futures.add(executor.submit(generator::getNextSequence));
        }

        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();

        return uniqueSequences;
    }

    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGenerator(), count);
        assertEquals(count, uniqueSequences.size());
    }

}
```

<br>

2. **Expected Generation of Sequence with Mutex Lock Using Synchronization Method Level** <br>
The underlying concept of synchronization is that **only one thread can execute a synchronized method for a given object at a time**. <br>
```java
public class SequenceGeneratorUsingSynchronizedMethod extends SequenceGenerator {

    @Override
    public synchronized int getNextSequence() {
        return super.getNextSequence();
    }

    @Test
    public void givenUnsafeSequenceGenerator_whenSequenceGeneratorUsingSynchronizedMethod_thenExpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingSynchronizedMethod(), count);
        assertEquals(count, uniqueSequences.size());
    }

}
```
<br>

3. **Expected Generation of Sequence with Mutex Lock Using Synchronization Block Level** <br>
```java
public class SequenceGeneratorUsingSynchronizedBlock extends SequenceGenerator {

    private Object mutex = new Object();

    @Override
    public int getNextSequence() {
        synchronized (mutex) {
            return super.getNextSequence();
        }
    }

    @Test
    public void givenUnsafeSequenceGenerator_whenSequenceGeneratorUsingSynchronizedBlock_thenExpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingSynchronizedBlock(), count);
        assertEquals(count, uniqueSequences.size());
    }
}
```

<br>

4. **Expected Generation of Sequence with Mutex Lock Using ReentrantLock** <br>
A closer look at the **ReentrantLock** class reveals that it is a **synchronization mechanism** that **implements the Lock interface**. <br>
![](https://github.com/Fas96/T-images-repo/blob/main/reentrantlock.png?raw=true)
<br>
```java
public class SequenceGeneratorUsingReentrantLock extends SequenceGenerator {

    private ReentrantLock mutex = new ReentrantLock();

    @Override
    public int getNextSequence() {
        try {
            mutex.lock();
            return super.getNextSequence();
        } finally {
            mutex.unlock();
        }
    }

    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenExpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingReentrantLock(), count);
        assertEquals(count, uniqueSequences.size());
    }
}
```

<br>

| **Working of a mutex**                                                                                                                                                                   |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1. Supposed one thread has locked a region of code using the mutex and is executing that piece of code                                                                                   |
| 2. Now if scheduler decides to do a context switch, then all the other threads which are ready to execute the same region are unblocked                                                  |
| 3.Only one of all the threads would make it to the execution but if this thread tries to execute the same region of the code<br/>that is already locked then it would again go to sleep. |
| 4. Context switch will take place again and again but no thread would be able to execute<br/>the locked region of the code until the mutex lock over it is released.                     |
| 5. Mutex lock will only be released by the thread who locked it.                                                                                                                         |
| 6. So this ensures that once a thread has locked a piece of code then no other thread can execute the same region until it is unlocked by the thread who locked it.                      |

<br>
<hr>

<hr>

### **7.what are the types of semaphores?** <br>
There are main two types of semaphores:
1. **Binary Semaphore:** A binary semaphore is a semaphore with a value of 0 or 1. It is used to control access to a shared resource. It is used to implement mutual exclusion. It is also used to implement synchronization between two processes. It is also used to implement synchronization between two threads.<br>
There’s a common misconception that they can be used interchangeably. But in fact, **a semaphore is a signaling mechanism where on the other hand, a mutex is a locking mechanism. So, we need to know that binary semaphore is not a mutex.** <br>
2. **Counting Semaphore:** A counting semaphore is a semaphore with a value of 0 or more. It is used to control access to a shared resource. It is used to implement mutual exclusion. It is also used to implement synchronization between two processes. It is also used to implement synchronization between two threads.<br>

<hr>

### **8.what is spooling?** <br>

**Spooling** is a process that temporarily stores data in a buffer and sends it to a **slow input/output device** in a continuous stream, making the system more efficient and responsive.
**Often stored in physical memory**, buffers, or interrupts. **FIFO is used to process the spool in ascending order.**

<br>
<hr>

### **9.what is thrashing?** <br>

**Thrash**  describe the poor performance of a virtual memory system when the same pages are loaded repeatedly owing to a shortage of **main memory to store them in secondary memory.**
<br>
<br>
**Thrashing** is when **virtual memory resources** are **overutilized**, resulting in a **persistent state of paging and page faults**, which inhibits most **application-level activity**. It causes the computer's performance to decline or collapse. The scenario can last indefinitely unless the user stops certain running apps or active processes to free up **extra virtual memory resources.**

<br>

**Page faults** and **Swapping** are important factors in understanding thrashing. <br>
**Page faults** a type of interrupt that occurs when a program attempts to access a page of memory that is not currently mapped to physical memory, leading to a disk I/O operation. <br>
**Swapping** is the process of moving pages of memory from physical memory to disk and vice versa. <br> 


### Summary
The above concepts have deeper implications in the field of Operating Systems. This post has only scratched the surface of the concepts. Each topic would be better understood if you go through the links provided in the references section. <br>
In subsequent post, if time permits, I would like to dive deeper into each question as a topic.
 

## References
1. [leetcode](https://leetcode.com/discuss/interview-question/operating-system/3216693/INTRESTING-INTERVIEW-QUESTIONS-IN-OS) <br>
2. [geeksforgeeks](https://www.geeksforgeeks.org/kernel-in-operating-system/) <br>
3. [TechOpedia](https://www.techopedia.com/definition/3328/bootstrap) <br>
4. [how Stuff Works](https://computer.howstuffworks.com/computer-run-without-operating-system.htm) <br>
5. [Baeldung](https://www.baeldung.com/java-mutex),[SEMAPHORES](https://www.baeldung.com/cs/semaphore) <br>
6. [NOTESJAM](https://www.notesjam.com/2017/10/spooling-in-operating-system.html) <br>
7. [WIKIPEDIA](https://en.wikipedia.org/wiki/Thrashing_(computer_science)#Other_uses) <br>
8. [I2Tutorial](https://www.i2tutorials.com/os-introduction/os-scheduling-criteria/) <br>
9. [NESO ACADEMY](https://www.youtube.com/watch?v=VjPgYcQqqN0&list=PLBlnK6fEyqRiVhbXDGLXDk_OQAeuVcp2O&ab_channel=NesoAcademy) <br>