/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot.indica;

import dev.inward.matrix.concept.fact.addressed.depot.DepotDirectoryKey;
import dev.inward.matrix.concept.fact.addressed.depot.DepotKey;

import java.net.URI;
import java.util.Objects;

public class IndicaKey extends DepotKey<Indica,IndicaKey,IndicaView,IndicaModel, IndicaReference, IndicaLibrarian> {

    protected IndicaKey(URI uri, String locus, DepotDirectoryKey directoryKey) {
        super(uri,locus,directoryKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uri.toString());
    }


    @Override
    public String toString() {
        return "Indicia{ locus='" + id +
                ", fullUri=" + uri +
                '}';
    }

    public String locus() {
        return id;
    }


    public static final class Builder extends DepotKey.Builder<IndicaKey,Indica,IndicaView,IndicaModel, IndicaReference, IndicaLibrarian> {

        @Override
        protected IndicaKey newMatrixKey() {
            return new IndicaKey(this.uri,this.id,this.directoryKey);
        }
    }
}
