package dev.inward.matrix.operation;

import dev.inward.matrix.Addressed;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Representative;
import dev.inward.matrix.info.Persona;

import java.net.URL;

public abstract class Operation<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>,O extends Operation<PATH,ID,I,A,R,F,O>> implements Comparable<O> {

    protected final URL url;
    protected final Persona persona;

    public Operation(URL url, Persona persona) {
        this.url = url;
        this.persona = persona;
    }

    public URL getUrl() {
        return url;
    }

    public Persona getPersona() {
        return persona;
    }

    @Override
    public int compareTo(O that) {
        return this.url.toString().compareTo(that.url.toString());
    }
}
