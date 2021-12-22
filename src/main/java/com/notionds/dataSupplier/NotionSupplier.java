package com.notionds.dataSupplier;

import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class NotionSupplier<DELEGATE extends Comparable<DELEGATE> & Serializable,O extends Operational<DELEGATE,W, C, B,?,D,A,P,L>,W extends Datum<DELEGATE,O, C, B>, C extends Container<DELEGATE,O,W,B>,B extends Bus<DELEGATE,O,W, C,?,?,?,?,?>,D extends Notion<DELEGATE,O,W, C, B>, A extends Advisor<DELEGATE,O,W, C, B>,P extends Provider<DELEGATE,O,W, C, B>,L extends NotionClassLoader<DELEGATE,O,W, C, B,?,D,A,P>> {

    private final O operational;
    private final String name;
    private final L classLoader;
    private final Class<DELEGATE> notionClass;


    public NotionSupplier(O operational, String name, L classLoader) {
        this.operational = operational;
        this.name = name;
        this.classLoader = classLoader;
        notionClass = ((Class<DELEGATE>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }



    public abstract C getNewContainer(O operational);
    public abstract DELEGATE createNotion();

    public final Class<DELEGATE> getNotionClass() {
        return this.notionClass;
    }
}
