/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.file.directory.*;

public class SchemeModel<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ControlModel<Scheme<DF,DK,DV,DM,DR,DL,PATH>,SchemeView<DF,DK,DV,DM,DR,DL,PATH>,SchemeModel<DF,DK,DV,DM,DR,DL,PATH>> {

    public SchemeModel(Class<? super Scheme<DF, DK, DV, DM, DR, DL, PATH>> controlClass, Aspect[] labeledAspects) {
        super(controlClass, labeledAspects);
    }
}
