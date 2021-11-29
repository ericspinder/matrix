package com.notionds.dataSupplier;

import com.notionds.dataSupplier.cron.Cron;
import com.notionds.dataSupplier.delegation.Delegation;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.exceptions.Advice;
import com.notionds.dataSupplier.operational.Operational;

public abstract class NotionSupplier<N, O extends Operational<N,W,T>, W extends Wrapper<N,O,T>, T extends Container<N,O,W>, A extends Advice<N,O,W>, D extends Delegation<N,O,W,T>, C extends Cron<N,O,W,T>, L extends NotionClassLoader<N,O,W,T,A,D,C>> {

    private final O options;
    private final String name;
    private final L classLoader;

    protected NotionSupplier(O options, String name, L classLoader) {
        this.options = options;
        this.name = name;
        this.classLoader = classLoader;
    }



    public abstract T getNewContainer(O operational);
    public abstract N createNotion();

}
