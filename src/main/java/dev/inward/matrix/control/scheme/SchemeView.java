/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.control.ControlView;
import dev.inward.matrix.file.directory.*;

public class SchemeView<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ControlView<Scheme<PATH,DK,DF,DV,DM,DR,DB>,SchemeView<PATH,DK,DF,DV,DM,DR,DB>,SchemeModel<PATH,DK,DF,DV,DM,DR,DB>> {

    public SchemeView(String name, Scheme<PATH,DK,DF,DV,DM,DR,DB> scheme, SchemeModel<PATH,DK,DF,DV,DM,DR,DB> schemeModel) {
        super(name, scheme, schemeModel);
    }
}
