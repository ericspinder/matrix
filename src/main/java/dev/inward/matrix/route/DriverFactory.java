/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class DriverFactory implements ThreadFactory {

    protected final AtomicLong driverNameCount = new AtomicLong();
    protected final Dispatch dispatch;
    protected final String driver_name_base;


    public DriverFactory(@Nonnull Dispatch dispatch, @Nullable String driver_name_base) {
        this.dispatch = dispatch;
        this.driver_name_base = Objects.requireNonNullElseGet(driver_name_base, () -> "Default_" + UUID.randomUUID() + '_' + dispatch.getName() + "_#");
    }

    @Override
    public Driver newThread(@NotNull Runnable r) {
        return new Driver(dispatch, r, String.format("%s_%s", driver_name_base, this.driverNameCount.getAndIncrement()), dispatch.getStackSize());
    }
}
