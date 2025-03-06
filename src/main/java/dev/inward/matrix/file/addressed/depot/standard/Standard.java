/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.depot.standard;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.depot.Depot;

public class Standard extends Depot<StandardKey,Standard,StandardReference,StandardAttributes,StandardResource,StandardModel> {

    protected final String description;
    protected final String modelClass;
    protected final Aspect[] aspects;
    protected final long warnOnTotalDefault;
    protected final long hardLimitDefault;



    public Standard(final StandardKey identity, final String description, String modelClass, Aspect[] aspects, long warnOnTotalDefault, long hardLimitDefault) {
        super(identity);
        this.description = description;
        this.modelClass = modelClass;
        this.aspects = aspects;
        this.warnOnTotalDefault = warnOnTotalDefault;
        this.hardLimitDefault = hardLimitDefault;
    }

    @Override
    public int compareTo(Standard o) {
        return 0;
    }

    public String getModelClass() {
        return modelClass;
    }

    public long getWarnOnTotalDefault() {
        return warnOnTotalDefault;
    }


    public long getHardLimitDefault() {
        return hardLimitDefault;
    }


}