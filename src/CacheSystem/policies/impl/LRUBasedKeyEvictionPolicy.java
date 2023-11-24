package CacheSystem.policies.impl;

import CacheSystem.policies.EvictionPolicy;

public class LRUBasedKeyEvictionPolicy<Key> implements EvictionPolicy<Key> {
    @Override
    public void keyAccessed(Key key) {
    }

    @Override
    public Key evictKey() {
        return null;
    }
}
