/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.Directory;
import dev.inward.matrix.file.DirectoryKey;

public class SeriesDirectory extends Directory<LogScheme, LogLibrary, LogPath> {

    public SeriesDirectory(DirectoryKey<LogScheme, LogLibrary, LogPath> parentDirectory) {
        super(parentDirectory);
    }
}
