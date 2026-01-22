/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed;

import dev.inward.matrix.concept.fact.FactContext;
import dev.inward.matrix.engine.Factory;
import dev.inward.matrix.concept.fact.Variant;
import dev.inward.matrix.concept.fact.directory.*;
import dev.inward.matrix.control.administrator.Agent;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.authority.AuthorityModel;
import dev.inward.matrix.control.authority.AuthorityView;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.scheme.SchemeModel;
import dev.inward.matrix.control.scheme.SchemeView;

public class AddressedContext<S extends Scheme<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,B extends Library<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,BV extends LibraryView<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,BM extends LibraryModel<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,A extends Authority<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DF extends Directory<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,PATH extends Comparable<PATH>,F extends Addressed<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH,F,ID,K,V,M,L,X>,ID extends Comparable<ID>,K extends AddressedKey<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH,F,ID,K,V,M,L,X>,V extends AddressedView<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH,F,ID,K,V,M,L,X>,M extends AddressedModel<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH,F,ID,K,V,M,L,X>,L extends AddressedLibrarian<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH,F,ID,K,V,M,L,X>,X extends AddressedContext<S,SV,SM,B,BV,BM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH,F,ID,K,V,M,L,X>> extends FactContext<F,K,V,M,L,X> {
    public AddressedContext(Variant variant, L concept, Factory<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> factory, Agent[] agents) {
        super(variant, concept, factory, agents);
    }
}
