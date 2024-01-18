
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
    private int maxSize;

    public Cache(int maxSize) {
        this.maxSize = maxSize;
        this.cacheList = new LinkedList<>();
    }

    /**
     * Returns true if the data object is found in the list, false otherwise.
     *
     * @param dataItem - data we are looking for
     * @return a boolean value
     */
    public boolean getObject(T dataItem) {
        return cacheList.contains(dataItem);
    }

    /**
     * Inserts data into top of cache (linkedlist)
     * If it's a cache hit, move the hit object to the front of the cache (MRU).
     * If it's a cache miss, add the data to the front of the cache.
     * 
     * @param dataItem - data to be added to top of cache
     */
    public void addObject(T dataItem) {

        if (cacheList.size() > maxSize) {
            removeObject(dataItem);
        }

        if (getObject(dataItem)) {
            cacheList.remove(dataItem);
        }
        cacheList.addFirst(dataItem);
    }

    /**
     * Removes the object from the cache.
     * 
     * @param dataItem - data to be removed
     */
    public void removeObject(T dataItem) {
        if (!cacheList.isEmpty()) {
            cacheList.removeLast();
        }
    }

    /**
     * Clears the cache.
     */
    public void clearCache() {
        cacheList.clear();
    }

}
