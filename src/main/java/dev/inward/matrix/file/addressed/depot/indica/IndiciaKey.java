/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.indica;

import dev.inward.matrix.file.DirectoryKey;
import dev.inward.matrix.file.addressed.depot.DepotKey;
import dev.inward.matrix.file.addressed.depot.DepotLibrary;
import dev.inward.matrix.file.addressed.depot.DepotPath;
import dev.inward.matrix.file.addressed.depot.DepotScheme;

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


    private IndiciaKey(URI uri, DirectoryKey<DepotScheme, DepotLibrary, DepotPath> parentDirectoryKey, String locus) {
        super(uri,parentDirectoryKey,locus);
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


    public static final class Builder {
        private URI uri;
        private DirectoryKey<DepotScheme,DepotLibrary,DepotPath> parentDirectoryKey;

        public Builder createUri(DepotLibrary depotLibrary) {
            StringBuilder sb = new StringBuilder();
            sb.append(parentDirectoryKey.getUri().toString()).append("/")
        }


    }
}
