package dev.inward.matrix;

import java.nio.file.Path;
import java.util.function.Function;

public interface MatrixFile<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,F>,FILE extends MatrixFile<PATH,K,FILE,F>,F extends FileAttributes<PATH,K,FILE,F>> extends Comparable<FILE> {

    public K getFileKey();

    default int compareTo(FILE that) {
        return this.getFileKey().compareTo(that.getFileKey());
    }

}
