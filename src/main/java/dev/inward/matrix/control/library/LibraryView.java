/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.library;

import dev.inward.matrix.control.ControlView;
import dev.inward.matrix.file.directory.*;

import java.nio.file.attribute.FileAttributeView;

public class LibraryView<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ControlView<Library<DF,DK,DV,DM,DR,DL,PATH>,LibraryView<DF,DK,DV,DM,DR,DL,PATH>,LibraryModel<DF,DK,DV,DM,DR,DL,PATH>> implements FileAttributeView {
    public LibraryView(String name, Library<DF,DK,DV,DM,DR,DL,PATH> library, LibraryModel<DF,DK,DV,DM,DR,DL,PATH> libraryModel) {
        super(name, library,libraryModel);
    }
}
