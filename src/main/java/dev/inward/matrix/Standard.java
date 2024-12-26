package dev.inward.matrix;

import dev.inward.matrix.code.Code;
import dev.inward.matrix.code.Path_ofCode;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.predictable.Criterion;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.function.Function;

public class Standard extends Code<Standard.Identity,Standard,Standard.Representative,Standard.StandardAttributes> {

    protected final String description;
    protected final String modelMakerClass;
    protected final Aspect[] aspects;

    protected long warnOnTotal;
    protected long hardLimit;

    public Standard(final Identity identity, final String description, String modelMakerClass, Aspect[] aspects, long warnOnTotal, long hardLimit) {
        super(identity);
        this.description = description;
        this.modelMakerClass = modelMakerClass;
        this.aspects = aspects;
        this.warnOnTotal = warnOnTotal;
        this.hardLimit = hardLimit;
    }

    @Override
    public int compareTo(Standard o) {
        return 0;
    }

    public static class Identity extends Code.Identity<Identity,Standard,Representative,StandardAttributes> {

        protected final String targetClassName;
        public Identity(String s, Query query, String targetClassName) {
            super(s,query);
            this.targetClassName = targetClassName;
        }

        public String getTargetClassName() {
            return targetClassName;
        }

        public String toString() {
            return this.targetClassName + '_' + this.id;
        }

    }
    public static class Representative extends Code.Representative<Identity,Standard, Representative, StandardAttributes> {

        public Representative(Standard datum, Resource resource) {
            super(datum, resource);
        }

    }
    public static class StandardAttributes extends Code.CodeAttributes<Identity,Standard,Representative,StandardAttributes> {

        public StandardAttributes(Standard datum) {
            super(datum);
        }
    }
    public static class Resource extends Code.Resource<Identity,Standard,Representative,StandardAttributes> {

        public Resource(dev.inward.matrix.Representative<?, ?, ?, ?, ?, ?> parent, String className, long warnOnTotal, long hardLimit, Function<Representative,Representative> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }
    public long getWarnOnTotal() {
        return warnOnTotal;
    }

    public void setWarnOnTotal(long warnOnTotal) {
        this.warnOnTotal = warnOnTotal;
    }

    public long getHardLimit() {
        return hardLimit;
    }

    public void setHardLimit(long hardLimit) {
        this.hardLimit = hardLimit;

    }
}