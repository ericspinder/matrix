/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.directory.DirectoryView;

public class LogDirectoryView extends DirectoryView<LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian,LogPath> {

    public LogDirectoryView(String name, LogDirectory logDirectory) {
        super(name, logDirectory);
    }
}
