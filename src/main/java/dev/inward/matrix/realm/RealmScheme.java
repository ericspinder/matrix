/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.realm;

import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.terrene.Terrene;

import java.net.URI;

public class RealmScheme extends Scheme<RealmScheme, RealmAuthority,String> {
    protected RealmScheme(Terrene terrene) {
        super(terrene, MatrixURLStreamHandlerProvider.Protocol.REALM);
    }

    @Override
    public RealmAuthority buildNewLibrary(URI uri) {
        return null;
    }

    @Override
    public int compareTo(RealmScheme o) {
        return 0;
    }
}
