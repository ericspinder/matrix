package dev.inward.matrix.datum.host;

import dev.inward.matrix.datum.protocol.Protocol;
import org.objectweb.asm.FieldVisitor;

import java.io.Serializable;

public final class RemoteHost<H extends RemoteHouse, P extends Protocol> implements Comparable<H>, Serializable {

    private H house;
    private P protocol;

    FieldVisitor

}
