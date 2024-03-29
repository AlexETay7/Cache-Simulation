/**
 * @author Alex Taylor CS321 Data Structures 1/18/24
 */

import java.util.LinkedList;

/**
 * A cache class that simulates
 * cache behavior.
 */
public class Cache<T> {
    private LinkedList<T> cacheList;
    private long maxSize;

    /**
     * Initializes a new Cache object.
     * @param maxSize - the max size of the cache
     */
    public Cache(long maxSize) {
        this.maxSize = maxSize;
        this.cacheList = new LinkedList<>();
    }

    /**
     * Returns true (cache hit) if the data object is found
     * in the list, false (cache miss) otherwise.
     *
     * @param dataItem - data we are looking for
     * @return true if data item is in list, false otherwise
     */
    public boolean getObject(T dataItem) {
        return cacheList.contains(dataItem);
    }

    /**
     * Inserts data into top of cache (linkedlist)
     * If it's a cache hit, move the hit object to the front of the cache (MRU).
     * If it's a cache miss, add the data to the front of the cache.
     * All logic to remove the object and add it back to the cache is done in this method.
     * 
     * @param dataItem - data to be added to top of cache
     */
    public void addObject(T dataItem) {

        if (cacheList.size() >= maxSize) {
            cacheList.removeLast();
        }
        cacheList.addFirst(dataItem);
    }

    /**
     * Removes the object from the cache.
     * 
     * @param dataItem - data to be removed
     */
    public void removeObject(T dataItem) {
        cacheList.remove(dataItem);
    }

    /**
     * Clears the cache.
     */
    public void clearCache() {
        cacheList.clear();
    }

}
