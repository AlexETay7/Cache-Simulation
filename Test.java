
/**
 * @author Alex Taylor CS321 Data Structures 1/18/24
 */

import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        Cache cacheOne = null;
        Cache cacheTwo = null;
        long numReferences1 = 0, numReferences2 = 0, numHits1 = 0, numHits2 = 0;
        long cacheSize1, cacheSize2;
        StringTokenizer token;
        int choice; 
        String readLine;
        String input;

        if ((args.length != 3) && (args.length != 4)) {
            System.out.println("Usage: java Test 1 <cache size> <textfile>");
            System.out.println("Usage: java Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>");
            System.exit(1);
        }

        choice = Integer.parseInt(args[0]);

        if ((choice != 1) && (choice != 2)) {
            System.out.println("Must choose option 1 or 2.");
            System.out.println("Usage: java Test 1 <cache size> <textfile>");
            System.out.println("Usage: java Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>");
            System.exit(1);
        }

        try {
            FileInputStream inputS = null;
            if ((args.length == 3) && (choice == 1)) {
                cacheSize1 = Integer.parseInt(args[1]);
                inputS = new FileInputStream(args[2]);
                cacheOne = new Cache<>(cacheSize1);
                System.out.println("A new cache has been created with " + cacheSize1 + " entries.");
            }

            if ((args.length == 4) && (choice == 2)) {
                cacheSize1 = Integer.parseInt(args[1]);
                cacheSize2 = Integer.parseInt(args[2]);
                cacheOne = new Cache<>(cacheSize1);
                cacheTwo = new Cache<>(cacheSize2);
                inputS = new FileInputStream(args[3]);
                System.out.println("The first level cache has been created with " + cacheSize1 + " entries.");
                System.out.println("The second level cache has been created with " + cacheSize2 + " entries.");
            }

            int numLines = 0;
            // time stamp?
            InputStreamReader inputR = new InputStreamReader(inputS);
            BufferedReader bReader = new BufferedReader(inputR);
            while (( readLine = bReader.readLine()) != null) {
                numLines++;
                token = new StringTokenizer(readLine, " ", false);
                while (token.hasMoreTokens()) {
                    input = token.nextToken();
                    numReferences1++;
                    cacheOne.addObject(input);
                }
            }



        } catch (Exception e) {

        }
    }

}