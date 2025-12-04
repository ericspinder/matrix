/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.authority;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.file.directory.*;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.scheme.SchemeModel;
import dev.inward.matrix.control.scheme.SchemeView;

public class AuthorityModel<S extends Scheme<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,A extends Authority<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,L extends Library<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DF extends Directory<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DR extends DirectoryReference<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,PATH extends Comparable<PATH>> extends ControlModel<A,AV,AM> {

    public AuthorityModel(Aspect[] labeledAspects) {
        super(Authority.class, labeledAspects);
    }

}