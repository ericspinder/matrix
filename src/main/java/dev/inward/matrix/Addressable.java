package dev.inward.matrix;

import java.io.Serializable;

public interface Addressable<UM> extends Comparable<UM>, Serializable {

    String getUrl();

}
