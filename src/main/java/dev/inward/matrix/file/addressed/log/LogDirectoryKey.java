/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.directory.DirectoryKey;

import java.net.URI;

public class LogDirectoryKey extends DirectoryKey<LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel, LogDirectoryReference, LogDirectoryLibrarian,LogPath> {
    protected LogDirectoryKey(URI uri, LogPath logPath) {
        super(uri,logPath);
    }

    public static class Builder extends DirectoryKey.Builder<LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel, LogDirectoryReference, LogDirectoryLibrarian,LogPath> {

        @Override
        protected LogDirectoryKey newMatrixKey() {
            return new LogDirectoryKey(this.uri,this.directoryPath);
        }
    }
}
