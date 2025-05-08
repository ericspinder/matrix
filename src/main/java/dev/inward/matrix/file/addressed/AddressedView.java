/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed;

import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.directory.*;

public class AddressedView<S extends Scheme<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,L extends Library<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LV extends LibraryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LM extends LibraryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LR extends LibraryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LB extends LibraryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,PATH extends Comparable<PATH>,C extends Catalog<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CV extends CatalogView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CM extends CatalogModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CR extends CatalogReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CB extends CatalogLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DK extends DirectoryKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,D extends Directory<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DV extends DirectoryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DM extends DirectoryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DR extends DirectoryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DB extends DirectoryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,ID extends Comparable<ID>,K extends AddressedKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,F extends Addressed<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,V extends AddressedView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,M extends AddressedModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,R extends AddressedReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>,B extends AddressedLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,ID,K,F,V,M,R,B>> extends FileView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B> {


    public AddressedView(String name, F file, R fileReference) {
        super(name, file, fileReference);
    }
}
