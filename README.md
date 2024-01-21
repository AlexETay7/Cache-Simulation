# Cache-Simulation
****************
* Cache Simulation
* Date 12/19/2024
* Alex Taylor
**************** 

### ***OVERVIEW:***

In this program, I designed a cache implementation using the linked list
data structure. The program can simulate the behavior of a single-level 
cache and a two-level cache. I also created a test class to verify the 
functionality of the cache.


### ***INCLUDED FILES:***

 * Cache.java - A collection of methods used to simulate cache behavior.
 * Test.java - Driver class used to test the correctness of cache implementation.
 * README - A brief overview of the program, how to run and compile it, related concepts, and testing information.


### ***COMPILING AND RUNNING:***

 In a terminal window, navigate to the directory containing all source files, compile the Test
 class with the command:
 <pre>
 $ javac Test.java
 </pre>

 To test a single cache implementation, run the command:
 <pre>
 $ java Test 1 <1st-level cache size> `<input textfile name>`
 </pre>

 To test a multi-level(two) cache implementation, run the command:
 <pre>
 $ java Test 2 <1st-level cache size> <2nd-level cache size> `<input textfile name>`
 </pre>

 The console output will give the results after the program finishes.


### ***PROGRAM DESIGN AND IMPORTANT CONCEPTS:***

This program implements a cache simulation using a linked list
data structure. A cache is a storage in memory, and data objects
in the cache are frequently accessed by the computer. This cache program
is a simulation of that behavior. The cache uses an MRU scheme. MRU 
stands for "Most Recently Used", where if a user needs a data item from 
the cache, the item is returned to the user and in turn placed at the top
of the cache. If the cache is full, the oldest entry in the cache is removed.

This program supports the implementation of two caches. The 2nd level
cache is usually bigger than the 1st level cache. The 2nd level cache 
contains all data that is in the 1st level cache. This is called the 
multilevel inclusion property. 

The global hit ratio for a single-level cache is defined by 
HR = (# of cache 1 hits / # of cache 1 references)

The global hit ratio for a multi-level cache is defined by 
HR = (# of cache 1 hits + # of cache 2 hits) / (# of cache 1 references)

The reason the global hit ratio for a multi-level cache is divided 
by only the number of references to the first cache is because we
have to consider the cache as a black box. 
This means the (# of cache 1 references = # of global references).


### ***TESTING:***

Test.java is the driver class and in turn the test class for the Cache 
class. I was able to verify the cache's functionality by comparing the 
outputs of my cache's hit and reference ratios output by Test.java to
the values given to me by my professor.
 

### ***REQUIRED RUNTIME:***
 
Program runtime is reported after each cache simulation is run.

The runtime for:

"java Test 2 1000 2000 Encyclopedia.txt" --> ≈ 7676 milliseconds

"java Test 2 1000 5000 Encyclopedia.txt" --> ≈ 15092 milliseconds

"java Test 2 <> <> small.txt" --> ≈ 1 millisecond

For reference, "small.txt" is a 2 line file, whereas "Encyclopedia.txt" 
is ≈ 147,000 lines long.
