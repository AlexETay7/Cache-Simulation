/**
 * The Test class for simulating cache behavior with multi-level caching.
 * 
 * @author Alex Taylor CS321 Data Structures 1/18/24
 */

 import java.io.*;
 import java.util.*;
 
 public class Test {
 
     public static void main(String[] args) {
 
         // Declare caches and counters
         Cache<String> cacheOne = null;
         Cache<String> cacheTwo = null;
         long numReferences1 = 0;
         long numReferences2 = 0; 
         long numHits1 = 0; 
         long numHits2 = 0;
         long cacheSize1;
         long cacheSize2;
         StringTokenizer token;
         int choice; 
         String readLine;
         String input;
         long startTime;
 
         // Check for correct number of command line arguments
         if ((args.length != 3) && (args.length != 4)) {
             System.out.println("Usage: java Test 1 <cache size> <textfile>");
             System.out.println("Usage: java Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>");
             System.exit(1);
         }
 
         // Parse the # of caches choice from command line arguments
         choice = Integer.parseInt(args[0]);
 
         // Validate the choice
         if ((choice != 1) && (choice != 2)) {
             System.out.println("Must choose option 1 or 2.");
             System.out.println("Usage: java Test 1 <cache size> <textfile>");
             System.out.println("Usage: java Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>");
             System.exit(1);
         }
 
         try {
             FileInputStream inputS = null;
 
             // Initialize the cache based on choice and input parameters
             if ((args.length == 3) && (choice == 1)) {
                 cacheSize1 = Integer.parseInt(args[1]);
                 inputS = new FileInputStream(args[2]);
                 cacheOne = new Cache<>(cacheSize1);
                 System.out.println("\nA single cache has been created with " + cacheSize1 + " entries.\n");
             }
 
             if ((args.length == 4) && (choice == 2)) {
                 cacheSize1 = Integer.parseInt(args[1]);
                 cacheSize2 = Integer.parseInt(args[2]);
                 cacheOne = new Cache<>(cacheSize1);
                 cacheTwo = new Cache<>(cacheSize2);
                 inputS = new FileInputStream(args[3]);
                 System.out.println("\nThe first level cache has been created with " + cacheSize1 + " entries.");
                 System.out.println("The second level cache has been created with " + cacheSize2 + " entries.\n");
             }
 
             int numLines = 0;
             startTime = System.currentTimeMillis();
             InputStreamReader inputR = new InputStreamReader(inputS);
             BufferedReader bReader = new BufferedReader(inputR);
 
             // Read each line from the input file
             while ((readLine = bReader.readLine()) != null) {
                 numLines++;
                 token = new StringTokenizer(readLine, " ", false);
 
                 // Process each token in the line
                 while (token.hasMoreTokens()) {
                     input = token.nextToken();
 
                     if ((args.length == 3) && (choice == 1)) {
                         // Case for single-level caching
                         numReferences1++;
                         if (cacheOne.getObject(input)) {
                             numHits1++;
                             cacheOne.removeObject(input);
                             cacheOne.addObject(input);
                         } else {
                             cacheOne.addObject(input);
                         }
                     } else {
                         // Case for two-level caching
                         numReferences1++;
                         if (cacheOne.getObject(input)) {
                             numHits1++;
                             cacheOne.removeObject(input);
                             cacheOne.addObject(input);

                             cacheTwo.removeObject(input);
                             cacheTwo.addObject(input);
                         } else {
                             numReferences2++;
                             if (cacheTwo.getObject(input)) {
                                 numHits2++;
                                 cacheTwo.removeObject(input);
                                 cacheTwo.addObject(input);
                                 cacheOne.addObject(input);
                             } else {
                                 cacheOne.addObject(input);
                                 cacheTwo.addObject(input);
                             }
                         }
                     }
                 }
             }

             // Calculate runtime
             long endTime = System.currentTimeMillis();
             long elapsedTime = endTime - startTime;
             
             // Print gloal references, and cache hits info
             System.out.println("The number of global references: " + numReferences1);
             System.out.println("The number of global cache hits: " + (numHits1 + numHits2));
             System.out.println("The global hit ratio                  : " + ((double)(numHits1 + numHits2) / numReferences1 + "\n"));

             // Print 1st-level references, and cache hits info
             System.out.println("The number of 1st-level references: " + numReferences1);
             System.out.println("The number of 1st-level cache hits: " + numHits1);
             System.out.println("The 1st-level cache hit ratio             : " + ((double)numHits1 / numReferences1) + "\n");

             if ((args.length == 4) && (choice == 2)) {
             // Print 2nd-level references, and cache hits info
             System.out.println("The number of 2nd-level references: " + numReferences2);
             System.out.println("The number of 2nd-level cache hits: " + numHits2);
             System.out.println("The 2nd-level cache hit ratio             : " + ((double)numHits2 / numReferences2) + "\n");
             }
             
             System.out.println("Program runtime: " + elapsedTime + " milliseconds");
             System.out.println("\n----------------------------------------------------------------");
 
         } catch (IOException e) {
             e.printStackTrace();
         } 
     }
 }
 