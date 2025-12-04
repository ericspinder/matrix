/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.MatrixItem;
import dev.inward.matrix.concept.file.addressed.log.Log;

import java.util.concurrent.TimeUnit;

public abstract class PolicyCriterion<PATH extends Comparable<PATH>,K extends MatrixKey<PATH,K,I>,I extends MatrixItem<PATH,K,I>,M extends Log> extends Criterion<PATH,K,I> {

    protected final int threads;
    protected final boolean autoStart;

    public PolicyCriterion(String label, String description, String i18n, int threads, boolean autoStart) {
        super(label, description, i18n);
        if (threads > 0) {
            this.threads = threads;
        }
        else {
            throw new RuntimeException("threads cannot be less than one");
        }
        this.autoStart = autoStart;
    }
    public abstract M createNewMatter(K matrixKey);
    /**
     *
     * @return  less than zero - don't do again, not a damon; Policy will not run again
     *          zero - no wait damon, do again immediately
     *          more than zero - number of TimeUnit values to wait before looping, default is seconds.
     */
    public abstract int getDamonSleep();
    public TimeUnit getDamonTimeUnit() {
        return TimeUnit.SECONDS;
    }
    public boolean isDamon() {
        return getDamonSleep() > 0;
    }
    public final boolean isSingleton() {
        return threads == 1;
    }

    public boolean isAutoStart() {
        return autoStart;
    }
}
