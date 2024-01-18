
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
        int choice; // = Integer.parseInt(args[0]);

        if ((args.length != 3) && (args.length != 4)) {
            System.out.println("Usage: java Test 1 <cache size> <textfile>");
            System.out.println("Usage: java Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>");

        }
    }

}