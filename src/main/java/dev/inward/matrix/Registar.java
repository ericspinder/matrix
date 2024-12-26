package dev.inward.matrix;

public class Registar<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,R,F>,FILE extends MatrixFile<PATH,K,FILE,R,F>,R extends Registar<PATH,K,FILE,R,F>,F extends FileAttributes<PATH,K,FILE,R,F>> extends Envoy<FILE,R,F> {
    public Registar(FILE datum, MatrixFile.Resource<PATH,K,FILE,R,F> resource) {
        super(datum, resource);
    }
}


