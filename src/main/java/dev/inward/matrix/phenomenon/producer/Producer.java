package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.phenomenon.Phenomenon;

import java.lang.ref.SoftReference;
import java.util.concurrent.Future;

public abstract class Producer<PRODUCT extends Product<PRODUCT,I,ID,VERSION,X>,I extends Identity<I,ID,VERSION,X>,ID extends Comparable<ID>,VERSION extends Comparable<VERSION>,X extends Context<VERSION,X>,W extends Producer<PRODUCT,I,ID,VERSION,X,W>> extends Phenomenon<W> implements Future<PRODUCT> {

    protected SoftReference<PRODUCT> product;

    protected Producer(Context.Ethereal ethereal, SoftReference road) {
        super(ethereal, road);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}