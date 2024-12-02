package com.example.Bag;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BagImpl<T> extends AbstractCollection<T> implements Bag<T> {

    private Map<T, Integer> map;

    public BagImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean add(T element) {
        map.put(element, map.getOrDefault(element, 0) + 1);
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
        return map.getOrDefault(element, 0);
    }

    @Override
    public void removeOccurrence(T element) {
        if (map.containsKey(element)) {
            int count = map.get(element);
            if (count > 1) {
                map.put(element, count - 1);
            } else {
                map.remove(element);
            }
        }
    }

    @Override
    public void removeAll(T element) {
        map.remove(element);
    }

    @Override
    public int size() {
        int total = 0;
        for (int count : map.values()) {
            total += count;
        }
        return total;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = map.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
