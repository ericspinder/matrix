/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.AddressedView;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.operation.Operation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

public abstract class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends AddressedReference<PATH,ID,I,A,R,F>,F extends AddressedView<PATH,ID,I,A,R,F>,O extends Operation<PATH,ID,I,A,R,F,O>> {

    private transient final StampedLock gate = new StampedLock();
    protected final Map<PATH, O> operations = new ConcurrentHashMap<>();


    public Gathering() {
    }

    public Map<PATH, O> getOperations() {
        return this.operations;
    }
}
