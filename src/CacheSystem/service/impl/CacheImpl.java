package CacheSystem.service.impl;

import CacheSystem.exceptions.NoKeyFoundException;
import CacheSystem.exceptions.StorageFullException;
import CacheSystem.policies.EvictionPolicy;
import CacheSystem.service.Cache;
import CacheSystem.storage.Storage;

public class CacheImpl<Key, Value> implements Cache<Key, Value> {
    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public CacheImpl(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public void addKey(Key key, Value value) {
        try {
            this.storage.addkey(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            System.out.println("Storage is full, evicting key based on eviction policy");
            Key evictKey = this.evictionPolicy.evictKey();
            try {
                this.storage.remove(evictKey);
            } catch (NoKeyFoundException ex) {
                System.out.println("Storage full, but no keys to evict");
                throw new RuntimeException(ex);
            }
            addKey(key, value);
        }
    }

    @Override
    public Value getKey(Key key) {
        this.evictionPolicy.keyAccessed(key);
        Value value;
        try {
            value = this.storage.getValue(key);
        } catch (NoKeyFoundException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
