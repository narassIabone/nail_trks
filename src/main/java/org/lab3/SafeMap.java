package org.lab3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SafeMap<K, V> implements Map<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Semaphore semaphore = new Semaphore(1);

    private void acquire() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void release() {
        semaphore.release();
    }

    @Override
    public int size() {
        acquire();
        try {
            return map.size();
        } finally {
            release();
        }
    }

    @Override
    public boolean isEmpty() {
        acquire();
        try {
            return map.isEmpty();
        } finally {
            release();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        acquire();
        try {
            return map.containsKey(key);
        } finally {
            release();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        acquire();
        try {
            return map.containsValue(value);
        } finally {
            release();
        }
    }

    @Override
    public V get(Object key) {
        acquire();
        try {
            return map.get(key);
        } finally {
            release();
        }
    }

    @Override
    public V put(K key, V value) {
        acquire();
        try {
            return map.put(key, value);
        } finally {
            release();
        }
    }

    @Override
    public V remove(Object key) {
        acquire();
        try {
            return map.remove(key);
        } finally {
            release();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        acquire();
        try {
            map.putAll(m);
        } finally {
            release();
        }
    }

    @Override
    public void clear() {
        acquire();
        try {
            map.clear();
        } finally {
            release();
        }
    }

    @Override
    public Set<K> keySet() {
        acquire();
        try {
            return new HashSet<>(map.keySet());
        } finally {
            release();
        }
    }

    @Override
    public Collection<V> values() {
        acquire();
        try {
            return new ArrayList<>(map.values());
        } finally {
            release();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        acquire();
        try {
            return new HashSet<>(map.entrySet());
        } finally {
            release();
        }
    }

    @Override
    public boolean equals(Object o) {
        acquire();
        try {
            return map.equals(o);
        } finally {
            release();
        }
    }

    @Override
    public int hashCode() {
        acquire();
        try {
            return map.hashCode();
        } finally {
            release();
        }
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        acquire();
        try {
            return map.getOrDefault(key, defaultValue);
        } finally {
            release();
        }
    }

    @Override
    public V putIfAbsent(K key, V value) {
        acquire();
        try {
            return map.putIfAbsent(key, value);
        } finally {
            release();
        }
    }

    @Override
    public boolean remove(Object key, Object value) {
        acquire();
        try {
            return map.remove(key, value);
        } finally {
            release();
        }
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        acquire();
        try {
            return map.replace(key, oldValue, newValue);
        } finally {
            release();
        }
    }

    @Override
    public V replace(K key, V value) {
        acquire();
        try {
            return map.replace(key, value);
        } finally {
            release();
        }
    }
}
