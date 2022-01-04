package dev.inward.matrix.id;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.operational.Operational;

import java.net.URL;
import java.util.UUID;

public abstract class Id<N extends Notion<N,O,C,B,I>,O extends Operational<N,O,N>,C extends Container<N,O,C,N,B>, B extends Bus<N,O,C,N,B,?,?,?>,I extends Id<N,O,C,B,I>> extends Datum<N,O,C,N,B> {

    private final UUID uuid;
    private final Authority

    public URL getUrl() {
        return null;
    }

}
