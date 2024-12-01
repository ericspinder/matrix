package dev.inward.matrix;

import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Operational;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.function.Consumer;

public class Standard extends Addressed<Branched,String,Standard.Identity,Standard, Standard.Representitive, Standard.Representitive> {

    protected final String description;
    protected final Criterion[] demonCriteria;

    public Standard(final Identity identity, final String description, Criterion[] demonCriteria) {
        super(identity);
        this.description = description;
        this.demonCriteria = demonCriteria;
    }

    @Override
    public Representitive getWare() {
        return null;
    }

    @Override
    public Representitive setWare() {
        return null;
    }

    @Override
    public int compareTo(Standard o) {
        return 0;
    }

    public static class Identity extends dev.inward.matrix.Identity<Branched,String,Identity,Standard,Representitive,Representitive> {

        protected final String className;
        public Identity(String s, String className) {
            super(s);
            this.className = className;
        }

        public String getClassName() {
            return className;
        }

        public String toString() {
            return this.className + '_' + this.id;
        }
        public String toJSONString() {
            final StringBuilder sb = new StringBuilder("dev.inward.matrix.Standard.Identity{");
            sb.append("className='").append(className).append('\'');
            sb.append(", id=").append(id);
            sb.append(", indices=");
            indices.forEach(branchedIndex -> {
                StringBuilder stringBuilder = sb.append('[').append(branchedIndex.toString()).append(']');
                if (!branchedIndex.equals(indices.getLast())) {
                    stringBuilder.append(',');
                }
            });
            sb.append('}');
            return sb.toString();
        }
    }
    public static class Representitive extends dev.inward.matrix.Representitive<Branched,String,Identity,Standard,Representitive,Representitive> {

        public Representitive(Standard datum, dev.inward.matrix.Resource<Standard, Representitive, Representitive> resource) {
            super(datum, resource);
        }

        @Override
        public String getPathString() {
            return null;
        }

        @Override
        public BasicFileAttributes readAttributes() throws IOException {
            return null;
        }

        @Override
        public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

        }
    }

    public Variant getVariant() {
        return variant;
    }

    public String getClassName() {
        return className;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getTransformerClassName() {
        return transformerClassName;
    }

    public String[] getInductionClassNames() {
        return inductionClassNames;
    }

    public Criterion[] getCriteria() {
        return criteria;
    }
}