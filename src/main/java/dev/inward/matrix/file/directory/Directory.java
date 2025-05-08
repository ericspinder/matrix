/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.directory;

import dev.inward.matrix.file.File;
import dev.inward.matrix.file.FileKey;

import java.util.Map;
import java.util.WeakHashMap;

public class Directory<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends File<DF,DK,DV,DM,DR,DL,DF,DK,DV,DM,DR,DL,PATH> {

    protected final Map<String,? extends FileKey<?,?,?,?,?,?,DF,DK,DV,DM,DR,DL,PATH>> fileKeys = new WeakHashMap<>();

    public Directory(DK directoryKey) {
        super(directoryKey);
    }

}


