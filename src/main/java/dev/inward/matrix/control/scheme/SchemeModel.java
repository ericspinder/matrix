/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.fact.directory.*;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.authority.AuthorityModel;
import dev.inward.matrix.control.authority.AuthorityView;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;

public class SchemeModel<S extends Scheme<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,L extends Library<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,A extends Authority<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DF extends Directory<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,PATH extends Comparable<PATH>> extends ControlModel<S,SV,SM> {

    public SchemeModel(Class<? super S> controlClass, Aspect[] labeledAspects) {
        super(controlClass, labeledAspects);
    }
}
