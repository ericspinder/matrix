package dev.inward.matrix;

import java.util.function.Function;

public abstract class MatrixFile<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,R,F>,FILE extends MatrixFile<PATH,K,FILE,R,F>,R extends Registar<PATH,K,FILE,R,F>,F extends FileAttributes<PATH,K,FILE,R,F>> implements Datum<FILE,R,F>, Comparable<FILE> {

    protected final K fileKey;

    public MatrixFile(K fileKey) {
        this.fileKey = fileKey;
    }

    public K getFileKey() {
        return fileKey;
    }

    public static class Resource<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,R,F>,FILE extends MatrixFile<PATH,K,FILE,R,F>,R extends Registar<PATH,K,FILE,R,F>,F extends FileAttributes<PATH,K,FILE,R,F>> extends DatumResource<FILE,R,F> {

        /**
         * @param parent
         * @param className
         * @param warnOnTotal
         * @param hardLimit
         * @param graveDigger
         */
        public Resource(Representative<?, ?, ?, ?, ?, ?> parent, String className, long warnOnTotal, long hardLimit, Function<R, R> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }
}
