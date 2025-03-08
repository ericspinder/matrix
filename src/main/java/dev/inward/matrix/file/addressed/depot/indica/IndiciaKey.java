/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.indica;

import dev.inward.matrix.file.addressed.depot.DepotDirectoryKey;
import dev.inward.matrix.file.addressed.depot.DepotKey;

import java.net.URI;
import java.nio.file.WatchEvent;
import java.util.Objects;

public class IndiciaKey extends DepotKey<IndiciaKey,Indica, IndicaReference, IndicaAttributes,IndicaResource,IndicaModel> implements WatchEvent.Kind<IndiciaKey> {

    public static final WatchEvent.Kind<IndiciaKey> Kind = new WatchEvent.Kind<>() {
        @Override
        public String name() {
            return "Indica";
        }

        @Override
        public Class<IndiciaKey> type() {
            return IndiciaKey.class;
        }
    };


    protected IndiciaKey(URI uri, String locus, DepotDirectoryKey directoryKey) {
        super(uri,locus,directoryKey);
    }


    @Override
    public String name() {
        return this.uri.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<IndiciaKey> type() {
        return (Class<IndiciaKey>) this.getClass();
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


    public static final class Builder extends DepotKey.Builder<IndiciaKey,Indica, IndicaReference, IndicaAttributes,IndicaResource,IndicaModel> {

        @Override
        protected IndiciaKey newFileKey() {
            return new IndiciaKey(this.uri,this.id,this.directoryKey);
        }
    }
}
