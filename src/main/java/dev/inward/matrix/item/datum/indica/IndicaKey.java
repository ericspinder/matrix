/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.indica;

import dev.inward.matrix.concept.fact.addressed.depot.DepotDirectoryKey;
import dev.inward.matrix.concept.fact.addressed.depot.DepotKey;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.URL;
import java.util.Objects;

public class IndicaKey extends DepotKey<Indica,IndicaKey,IndicaView,IndicaModel,IndicaReference,IndicaLibrarian> {

    protected IndicaKey(URI uri,  DepotDirectoryKey directoryKey) {
        super(uri,locus,directoryKey);
    }

    @Override
    protected URL processUri(URI uri) {
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uri.toString());
    }


    @NotNull
    @Override
    public String toString() {
        return "Indicia{ locus='" + id +
                ", fullUri=" + uri +
                '}';
    }
}
