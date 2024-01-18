
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
     * If it's a cache hit, move the hit object to the front of the cache (MRU).
     * If it's a cache miss, add the data to the front of the cache.
     *
     * @param dataItem - data we are looking for
     * @return a boolean value
     */
    public boolean getObject(T dataItem) {
        boolean isHit = cacheList.contains(dataItem);

        if (isHit) {
            // Move the hit object to the front of the cache (MRU)
            cacheList.remove(dataItem);
        }

        // Add the data item to the front of the cache
        cacheList.addFirst(dataItem);

        // If the cache size exceeds the limit, remove the oldest item
        if (cacheList.size() > maxSize) {
            removeObject(dataItem);
        }

        return isHit;
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
