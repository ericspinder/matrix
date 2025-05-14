/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.standard;

import dev.inward.matrix.file.addressed.depot.DepotDirectoryKey;
import dev.inward.matrix.file.addressed.depot.DepotKey;

import java.net.URI;

public class StandardKey extends DepotKey<Standard,StandardKey,StandardView,StandardModel,StandardReference,StandardLibrarian> {
    protected StandardKey(URI uri, String id, DepotDirectoryKey directory) {
        super(uri, id, directory);
    }

    public static class Builder extends DepotKey.Builder<Standard,StandardKey,StandardView,StandardModel,StandardReference,StandardLibrarian> {

        @Override
        protected StandardKey newMatrixKey() {
            return new StandardKey(this.uri,this.id,this.directoryKey);
        }
    }
}
