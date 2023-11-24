package CacheSystem.storage.impl;

import CacheSystem.exceptions.NoKeyFoundException;
import CacheSystem.exceptions.StorageFullException;
import CacheSystem.storage.Storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
    private Map<Key, Value> cacheMap;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.cacheMap = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void addkey(Key key, Value value) throws StorageFullException {
        if (cacheMap.containsKey(key)) {
            System.out.println("Key already exists in the cacheMap");
        }
        if (isStorageFull()) {
            throw new StorageFullException("Storage is full.");
        }
        cacheMap.put(key, value);
    }

    private boolean isStorageFull() {
        return cacheMap.size() == capacity;
    }

    @Override
    public Value getValue(Key key) throws NoKeyFoundException {
        isKeyPresent(key);
        return cacheMap.get(key);
    }

    @Override
    public boolean remove(Key key) throws NoKeyFoundException {
        isKeyPresent(key);
        cacheMap.remove(key);
        return true;
    }

    private void isKeyPresent(Key key) throws NoKeyFoundException {
        if (!cacheMap.containsKey(key)) {
            throw new NoKeyFoundException("Key is not found in the cache");
        }
    }


}
