/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot.indica;

import dev.inward.matrix.Matrix;
import dev.inward.matrix.concept.fact.addressed.depot.DepotDirectoryKey;
import dev.inward.matrix.concept.fact.addressed.depot.DepotKey;
import dev.inward.matrix.predictable.Predictable;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Objects;

public class IndicaKey<P extends Predictable> extends DepotKey<Indica<P>,IndicaKey<P>,IndicaView<P>,IndicaModel<P>, IndicaReference<P>, IndicaLibrarian<P>> implements WatchEvent.Kind<Indica<P>> {

    protected IndicaKey(URI uri, String predictableClass, String locus, DepotDirectoryKey directoryKey) {
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


    @Override
    public String toString() {
        return "Indicia{ locus='" + id +
                ", fullUri=" + uri +
                '}';
    }

    public String locus() {
        return id;
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public Class<P> type() {
        Matrix.getInstance().this.url
        return ;
    }


    public static final class Builder extends DepotKey.Builder<IndicaKey,Indica,IndicaView,IndicaModel, IndicaReference, IndicaLibrarian> {

        @Override
        protected IndicaKey newMatrixKey() {
            return new IndicaKey(this.uri,this.id,this.directoryKey);
        }
    }
}
