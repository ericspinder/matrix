/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.operation;

import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.AddressedView;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.file.addressed.info.Persona;

import java.net.URL;

public abstract class Operation<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends AddressedReference<PATH,ID,I,A,R,F>,F extends AddressedView<PATH,ID,I,A,R,F>,O extends Operation<PATH,ID,I,A,R,F,O>> implements Comparable<O> {

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
