package com.notionds.dataSupplier.delegation;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.operational.Operational;

import java.util.UUID;

public interface Wrapper<N,O extends Operational<N,?>, T extends Container<N,O,?>> {

    UUID getArtifactId();

    T getContainer();

    N getDelegate();

}
