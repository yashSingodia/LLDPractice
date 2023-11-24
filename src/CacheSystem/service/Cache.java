package CacheSystem.service;

public interface Cache<Key, Value> {
    void addKey(Key key, Value value);

    Value getKey(Key key);
}
