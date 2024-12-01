package dev.inward.matrix;

import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.datum.Envoy;

import java.nio.file.attribute.*;
import java.time.Instant;
import java.util.*;

public abstract class Representitive<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representitive<PATH,ID,I,A,R>> extends Envoy<A,R> implements BasicFileAttributeView {

    public Representitive(A datum, Resource<A,R> resource) {
        super(datum, resource);
    }

    public static class FileAttributes extends dev.inward.matrix.FileAttributes {

        public FileAttributes(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isRegularFile() {
            return true;
        }

        @Override
        public boolean isDirectory() {
            return false;
        }

        @Override
        public boolean isSymbolicLink() {
            return false;
        }

        @Override
        public boolean isOther() {
            return false;
        }
    }

    protected final FileAttributes fileAttributes;




    @Override
    public String name() {
        return (String) fileAttributes.properties.computeIfAbsent("name", k -> Objects.requireNonNull(this.get()).getIdentity().toString());
    }


    public boolean release() {
        if (isHeld()) {
            this.fileAttributes.properties.remove("held");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isHeld() {
        return this.fileAttributes.properties.get("held") != null;
    }

    public Instant getUpdateTime() {
        return (Instant) fileAttributes.properties.get("updateTime");
    }


    public void setThenReturnUpdateTime() {
        this.fileAttributes.properties.put("updateTime", Instant.now());
    }

    @Override
    public boolean enqueue() {
        this.fileAttributes.properties.remove("hold");
        return super.enqueue();
    }

}
