package CacheSystem.storage;

import CacheSystem.exceptions.NoKeyFoundException;
import CacheSystem.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    void addkey(Key key, Value value) throws StorageFullException;
    Value getValue(Key key) throws NoKeyFoundException;

    boolean remove(Key key) throws NoKeyFoundException;
}
