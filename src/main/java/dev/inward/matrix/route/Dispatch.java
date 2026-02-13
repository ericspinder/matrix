/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import dev.inward.matrix.item.materilized.administrator.Materialized;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Dispatch extends ThreadGroup implements Comparable<Dispatch> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Materialized<?,?,?,?> materialized;
    public final String description;
    protected volatile int corePoolSize;
    protected volatile int maximumPoolSize;
    protected volatile long keepAliveTime;
    protected volatile TimeUnit defaultTimeUnit;
    protected volatile long stackSize;


    public Dispatch(String name, Materialized<?,?,?,?> materialized, @Nullable String description, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit defaultTimeUnit, long stackSize) {
        super(name);
        this.materialized = materialized;
        this.description = Objects.requireNonNullElse(description, "No description provided");
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.defaultTimeUnit = defaultTimeUnit;
        this.stackSize = stackSize;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getDefaultTimeUnit() {
        return defaultTimeUnit;
    }

    public void setDefaultTimeUnit(TimeUnit defaultTimeUnit) {
        this.defaultTimeUnit = defaultTimeUnit;
    }

    public long getStackSize() {
        return stackSize;
    }

    @Override
    public int compareTo(Dispatch that) {
        return  this.uuid.compareTo(that.uuid);
    }
    @Override
    public String toString() {
        return "Dispatch: name = " + ", description = " + description + getName() + "\t UUID = " + uuid;
    }
}