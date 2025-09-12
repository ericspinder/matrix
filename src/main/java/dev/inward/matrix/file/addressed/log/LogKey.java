/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;
import java.util.UUID;

public class LogKey extends AddressedKey<Log,UUID, LogKey, LogView, LogModel, LogReference, LogLibrarian,LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel, LogDirectoryReference, LogDirectoryLibrarian,LogPath> {


    protected LogKey(URI uri, UUID uuid, LogDirectoryKey directoryKey) {
        super(uri, uuid, directoryKey);
    }

    public static class Builder extends AddressedKey.Builder<Log,UUID, LogKey, LogView, LogModel, LogReference, LogLibrarian,LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel, LogDirectoryReference, LogDirectoryLibrarian,LogPath> {

        @Override
        protected LogKey newMatrixKey() {
            return new LogKey(this.uri, this.id,this.directoryKey);
        }
    }
}