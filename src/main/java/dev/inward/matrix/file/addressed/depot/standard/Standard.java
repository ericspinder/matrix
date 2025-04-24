/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.depot.standard;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.depot.Depot;

public class Standard extends Depot<StandardKey,Standard,StandardView,StandardModel,StandardReference, StandardLibrarian> {

    protected final Aspect[] aspects;
    protected final String graveDiggerClassName;
    protected final long warnOnTotalDefault;
    protected final long hardLimitDefault;



    public Standard(final StandardKey identity, Aspect[] aspects, String graveDiggerClassName, long warnOnTotalDefault, long hardLimitDefault) {
        super(identity);
        this.aspects = aspects;
        this.graveDiggerClassName = graveDiggerClassName;
        this.warnOnTotalDefault = warnOnTotalDefault;
        this.hardLimitDefault = hardLimitDefault;
    }

    public String getGraveDiggerClassName() {
        return graveDiggerClassName;
    }

    public Aspect[] getAspects() {
        return aspects;
    }

    public long getWarnOnTotalDefault() {
        return warnOnTotalDefault;
    }


    public long getHardLimitDefault() {
        return hardLimitDefault;
    }


}