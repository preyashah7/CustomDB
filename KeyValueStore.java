import java.util.HashMap;

public class KeyValueStore<K, V> {
    private final HashMap<K, V> store;
    private final LRUcache<K, V> cache;

    public KeyValueStore(int cacheCapacity) {
        this.store = new HashMap<>();
        this.cache = new LRUcache<>(cacheCapacity);
    }

    public void put(K key, V value) {
        store.put(key, value);
        cache.put(key, value);
        saveToFile("data.json"); // save after put
        System.out.println("Stored: " + key + " = " + value);
    }

    public void delete(K key) {
        if (store.containsKey(key)) {
            store.remove(key);
            // Optionally also remove from cache
            cache.remove(key);
            saveToFile("data.json"); // save after delete
            System.out.println("Deleted: " + key);
        } else {
            System.out.println("Key not found: " + key);
        }
    }


    public V get(K key) {
        // Try cache first
        V value = cache.get(key);
        if (value != null) {
            return value;
        }

        // If not found, check main store
        value = store.get(key);
        if (value != null) {
            cache.put(key, value); // re-cache it
            System.out.println("Loaded from store: " + key + " = " + value);
        } else {
            System.out.println("Key not found in cache or store: " + key);
        }
        return value;
    }

    public void saveToFile(String filename) {
    PersistenceManager.saveToFile(store, filename);
}

    public void loadFromFile(String filename) {
        HashMap<K, V> loaded = PersistenceManager.loadFromFile(filename);
        store.clear();
        store.putAll(loaded);
        for (K key : loaded.keySet()) {
            cache.put(key, loaded.get(key));
        }
    }


}
