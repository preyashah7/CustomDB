import java.util.HashMap;

public class LRUcache<K, V> {
    private final int capacity;
    private final HashMap<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;

    public LRUcache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            System.out.println("Cache Miss: " + key);
            return null;
        }
        Node<K, V> node = map.get(key);
        list.moveToFront(node);
        System.out.println("Cache Hit: " + key + " = " + node.value);
        return node.value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            list.moveToFront(node);
            System.out.println("Cache Updated: " + key + " = " + value);
        } else {
            if (map.size() == capacity) {
                Node<K, V> lru = list.removeLast();
                if (lru != null) {
                    map.remove(lru.key);
                    System.out.println("Cache Evicted: " + lru.key);
                }
            }
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            list.addToFront(newNode);
            System.out.println("Cache Inserted: " + key + " = " + value);
        }
    }

    public void remove(K key) {
    if (map.containsKey(key)) {
        Node<K, V> node = map.get(key);
        list.remove(node);     // remove from linked list
        map.remove(key);       // remove from map
        System.out.println("Cache Removed: " + key);
    }
}

}
    