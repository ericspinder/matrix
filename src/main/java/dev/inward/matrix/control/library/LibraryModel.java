/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.library;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.file.directory.*;

public class LibraryModel<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ControlModel<Library<DF,DK,DV,DM,DR,DL,PATH>,LibraryView<DF,DK,DV,DM,DR,DL,PATH>,LibraryModel<DF,DK,DV,DM,DR,DL,PATH>> {

    public LibraryModel(Aspect[] labeledAspects) {
        super(Library.class, labeledAspects);
    }

}