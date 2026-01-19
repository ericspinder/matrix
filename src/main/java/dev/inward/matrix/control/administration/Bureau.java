/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.administration;

import dev.inward.matrix.Shadow;
import dev.inward.matrix.concept.fact.FactView;
import dev.inward.matrix.concept.fact.addressed.*;
import dev.inward.matrix.concept.fact.directory.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.concept.item.datum.administrator.Persona;

import java.util.Map;

public abstract class Bureau<BC extends Bureau<BC,BV,BM>,BV extends BureauView<BC,BV,BM>,BM extends BureauModel<BC,BV,BM>> implements Control<BC,BV,BM> {



    @SuppressWarnings("unchecked")
    public Bureau(String name, boolean readOnly, Map<String,Object> attributes, Class<FactView<?,?,?,?,?,?>>[] supportedFileViews) {
        super(name, readOnly, attributes,supportedFileViews);

    }

    public abstract <F extends Addressed<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,ID extends Comparable<ID>,K extends AddressedKey<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,V extends AddressedView<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,M extends AddressedModel<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,R extends Shadow<F>,L extends AddressedLibrarian<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends Shadow,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> F getFile(K key, Persona persona);



}