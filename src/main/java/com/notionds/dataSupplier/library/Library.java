package com.notionds.dataSupplier.library;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.notion.Notion;

import java.io.Serializable;

public abstract class Library<L extends Library<L>> implements Comparable<L>, Serializable {

    private final Domain domain;

    public Library(Domain domain) {
        this.domain = domain;
    }

//    private final Map<String,

    public abstract <N extends Notion<N,?,?,I>,I extends Id.Ego<I>,X extends Context<X>> N getNotion(I id);

}
