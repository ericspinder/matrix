package dev.inward.matrix;

import java.io.IOException;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.util.*;

public abstract class Representative<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>> extends Envoy<A,R,F> implements BasicFileAttributeView {

    public Representative(A addressed, Addressed.Resource<PATH,ID,I,A,R,F> resource) {
        super(addressed, resource);
    }

    @Override
    public String name() {
        return (String) this.attributes.properties.computeIfAbsent("identity", k -> Objects.requireNonNull(this.get()).getFileKey().toString());
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return this.attributes;
    }

    @Override
    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

    }


    public boolean release() {
        if (isHeld()) {
            this.attributes.properties.remove("held");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isHeld() {
        return this.attributes.properties.get("held") != null;
    }


}
