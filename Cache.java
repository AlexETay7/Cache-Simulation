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
     * Returns true if the data object is found
     * in the list, false otherwise
     * 
     * @param dataItem - data we are looking for
     * @return a boolean value
     */
    public boolean getObject(T dataItem) {
        return cacheList.contains(dataItem);
    }

    /**
     * Inserts data into top of cache (linkedlist)
     * 
     * @param dataItem - data to be added to top of cache
     */
    public void addObject(T dataItem) {

    }

    // Method to remove an object from the cache
    public void removeObject(T dataItem) {

    }

    // Method to clear the entire cache
    public void clearCache() {

    }

}
