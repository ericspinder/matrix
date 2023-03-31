package dev.inward.matrix.engine;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.Authority;
import dev.inward.matrix.fact.authoritative.notion.authority.Clerk;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.security.CodeSource;

public class Variant extends CodeSource {

    protected final Authority authority;
    protected final Domain domain;

    public Variant(@Nonnull Authority authority, @Nullable Domain domain) {
        super(authority.getURL(domain), authority.getCodeSigners(domain));
        this.authority = authority;
        this.domain = domain;
    }

    public Domain getDomain() {
        return domain;
    }

    public static Variant Aforementened = new Variant(Clerk.Aforementioned,);

}
