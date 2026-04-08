import java.util.HashMap; // import HashMap for quick key->node lookup
import java.util.Map; // import Map interface for the node cache

// Problem: LeetCode 146 - LRU Cache
// Pattern: HashMap + Doubly Linked List
// Core idea: HashMap gives O(1) key lookup, doubly linked list maintains usage order (MRU at head, LRU at tail).
// Invariant: head.next is most recently used node, tail.prev is least recently used node.
// Complexity: O(1) average for get/put, O(capacity) space.
// Dry run: cap=2 -> put(1),put(2),get(1),put(3) evicts 2, put(4) evicts 1.
// Why this works: Every access promotes node to head, and eviction always removes tail.prev (true LRU).
// Mental Trigger (simple): Map finds node fast, list keeps order; use head for newest and tail for oldest.
// When to use: Node-level rewiring/traversal problems with O(1) extra space goals.
// Failure mode: Losing links during pointer updates or null checks in wrong order.
// Input edge cases: Empty list, one node, two nodes, cycle present at head.
// Brute -> Optimal jump: Avoid arrays; use pointer choreography (dummy/slow-fast/prev-curr).
// Invariant break test: Processed part remains valid and unprocessed part stays reachable.
// Complexity trigger: Single traversal with constant auxiliary pointers.
// Common variant: reverse segment, detect cycle, merge/reorder by pointers.
// Flow Dry Run (same order as code below):
// A) get(key): miss -> -1, hit -> move node to head.
// B) put(key,val): update existing and move to head, else insert new at head.
// C) If size exceeds capacity, remove node before tail and delete from map.
// D) Sentinels head/tail make insert/remove constant-time and edge-safe.
class LRUCache {

    private static class Node { // doubly linked list node stores key/value and neighbors
        int key; // key of this cache entry
        int value; // value of this cache entry
        Node prev; // pointer to previous node in list
        Node next; // pointer to next node in list

        Node(int key, int value) { // node constructor sets key and value
            this.key = key; // store provided key
            this.value = value; // store provided value
        }
    }

    private final int capacity; // maximum number of entries allowed
    private final Map<Integer, Node> map; // map from key to node for O(1) access
    private final Node head; // dummy head sentinel of doubly linked list
    private final Node tail; // dummy tail sentinel of doubly linked list

    public LRUCache(int capacity) { // cache constructor with fixed capacity
        this.capacity = capacity; // save capacity
        this.map = new HashMap<>(capacity); // initialize map with approximate size
        head = new Node(0, 0); // create dummy head node
        tail = new Node(0, 0); // create dummy tail node
        head.next = tail; // link head to tail
        tail.prev = head; // link tail back to head
    }

    public int get(int key) { // read operation for cache
        Node node = map.get(key); // look up node by key in map
        if (node == null) { // if key is not present
            return -1; // return -1 for cache miss
        }
        moveToHead(node); // on cache hit, move node to most recently used position
        return node.value; // return stored value
    }

    public void put(int key, int value) { // write/update operation for cache
        Node node = map.get(key); // check whether node already exists
        if (node != null) { // if key exists in cache
            node.value = value; // update the value of existing node
            moveToHead(node); // mark existing node as most recently used
        } else { // if key does not exist yet
            Node newNode = new Node(key, value); // create a new node for key/value
            map.put(key, newNode); // store mapping from key to node
            addToHead(newNode); // insert new node at head as most recently used
            if (map.size() > capacity) { // if cache exceeded capacity
                /*
                 Snapshot Example (cap=2):
                 put(1), put(2) -> list: 2,1
                 get(1) -> list: 1,2
                 put(3) -> evict 2, list: 3,1
                */
                Node lru = tail.prev; // least recently used node is just before tail
                removeNode(lru); // remove LRU node from linked list
                map.remove(lru.key); // remove LRU key from map
            }
        }
    }

    private void addToHead(Node node) { // helper to insert node immediately after head
        node.prev = head; // set new node previous pointer to head
        node.next = head.next; // set new node next pointer to old first node
        head.next.prev = node; // link old first node back to new node
        head.next = node; // link head forward to new node
    }

    private void removeNode(Node node) { // helper to unlink node from list
        node.prev.next = node.next; // bypass node by linking previous directly to next
        node.next.prev = node.prev; // bypass node by linking next back to previous
    }

    private void moveToHead(Node node) { // helper to reposition existing node as most recent
        removeNode(node); // unlink node from its current position
        addToHead(node); // insert node right after head
    }

    public static void main(String[] args) { // example usage of LRUCache
        LRUCache cache = new LRUCache(2); // create cache with capacity 2

        cache.put(1, 1); // insert key=1, value=1
        cache.put(2, 2); // insert key=2, value=2
        System.out.println(cache.get(1));       // get key=1, returns 1 and moves it to head
        cache.put(3, 3);    // insert key=3, evicts least recently used key=2
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

}

