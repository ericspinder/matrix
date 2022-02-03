package com.notionds.dataSupplier.aggregation;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.fact.notion.Notion;
import com.notionds.dataSupplier.house.Ego;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

public class NotionEviction<I extends Ego<?,?,I,X>,X extends Context<?,?,X>,N extends Notion<?,?,?,I>> extends LinkedHashMap<I,N> {

    private int maxSize;
    private int reaperLine = 1;
    private long overflowCount = 0;
    private int unresolvedNesting = 0;
    private final Lock gate = new StampedLock().asWriteLock();
    @Override
    protected boolean removeEldestEntry(Map.Entry<I,N> eldest) {
        if (size() > maxSize) {
            try {
                gate.lock();
                if (eldest.getValue(). > reaperLine) {
                    if (size() > ++unresolvedNesting) {
                        reaperLine++;
                        unresolvedNesting = 0;
                    }
                    this.remove(eldest.getKey());
                    this.put(eldest.getKey(), eldest.getValue());
                    this.
                } else {
                    //can remove
                    overflowCount++;
                    return true;
                }
            }
            finally {
                gate.unlock();
            }
        }
        return false;
    }
}
