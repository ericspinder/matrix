/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedView;

import java.util.UUID;

public class LogView extends AddressedView<Log,UUID, LogKey, LogView, LogModel, LogReference, LogLibrarian,LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel, LogDirectoryReference, LogDirectoryLibrarian,LogPath> {


    public LogView(String name, Log log) {
        super(name, log);
    }
}
