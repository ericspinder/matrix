package com.notionds.dataSupplier.library;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.notion.Notion;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.house.House;

import java.io.Serializable;

public class Library<H extends House<H,L>, L extends Library<H,L>> implements Comparable<L>, Serializable {


    public Library() {

    }

    private final Map<String, >

    public <N extends Notion<N,?,?,I>,I extends Ego<?,?,I,X>,X extends Context<?,?,X>> N getNotion(I id) {
        id.getContext().getPath()
    }

    @Override
    public int compareTo(L o) {
        return 0;
    }
}
