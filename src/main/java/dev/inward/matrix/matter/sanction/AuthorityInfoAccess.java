package dev.inward.matrix.matter.sanction;

import java.net.InetAddress;

public abstract class AuthorityInfoAccess {

    public enum Type {
        OnLineCertificate,
        CertificationAuthorityIssuer,

    }

    protected final InetAddress address;
    protected final String
}
