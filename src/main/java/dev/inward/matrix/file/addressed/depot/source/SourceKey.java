/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.source;

import dev.inward.matrix.file.addressed.depot.DepotDirectoryKey;
import dev.inward.matrix.file.addressed.depot.DepotKey;

import java.net.URI;

public class SourceKey extends DepotKey<SourceKey,Source,SourceReference,SourceAttributes,SourceResource,SourceModel> {
    protected SourceKey(URI uri, String id, DepotDirectoryKey directory) {
        super(uri, id, directory);
    }

    public static class Builder extends DepotKey.Builder<SourceKey,Source,SourceReference,SourceAttributes,SourceResource,SourceModel> {

        @Override
        protected SourceKey newFileKey() {
            return new SourceKey(this.uri,this.id,this.directoryKey);
        }
    }
}
