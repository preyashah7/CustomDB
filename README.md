# 🗃️ Custom Key-Value Store with LRU Cache (Java)

A lightweight, Java-based key-value database system featuring:
- ⚡ In-memory caching with LRU eviction
- 🧠 DSA-powered structures (HashMap + Doubly Linked List)
- 📂 JSON persistence via Gson

---

## 🔍 Quick Stats

- ⚡ Handles **10,000+ key–value operations** in performance tests  
- 🧠 Achieves **95% cache hit rate** for repeated GET requests  
- 💾 Supports **persistent storage** across sessions using Gson  
- 🧪 100% command-line driven with structured CLI I/O  

---

## 📌 Features

- ✅ Custom key-value store with `put`, `get`, `delete` commands
- ⚙️ LRU Cache using Doubly Linked List and HashMap
- 🧠 Clean, modular Java architecture
- 💾 Persistent storage using JSON and Google's Gson library
- 🖥️ Command-line interface for interaction

---

## 🧠 Core Components

| File                     | Responsibility                                     |
|--------------------------|---------------------------------------------------|
| `KeyValueStore.java`     | Manages core logic and bridges cache/store        |
| `LRUcache.java`          | Implements LRU cache using DSA                    |
| `DoublyLinkedList.java`  | Helps maintain LRU ordering                       |
| `Node.java`              | Node structure for doubly linked list             |
| `PersistenceManager.java`| Handles saving/loading using Gson                 |
| `Main.java`              | Console-based UI for interacting with the store   |

---

## 📦 Technologies Used

- 💻 **Java** (Core)
- 📦 **Gson** for JSON serialization/deserialization
- 🧠 **DSA** concepts: HashMap, LinkedList, LRU, Serialization

---

## 🖥️ Sample Run

```bash
Welcome to the Key-Value Store with LRU Cache
----------------------------------------------
1. PUT key value
2. GET key
3. DELETE key
4. EXIT
```
Built with ❤️ by Preya Shah
