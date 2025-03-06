/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed;

import dev.inward.matrix.LibraryKey;
import dev.inward.matrix.file.FileResource;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class AddressedResource<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends AddressedCatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends AddressedCatalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends AddressedDirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends AddressedDirectory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends AddressedDirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends AddressedDirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends AddressedDirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends AddressedDirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,ID extends Comparable<ID>,K extends AddressedKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,F extends Addressed<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,R extends AddressedReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,A extends AddressedAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,RESOURCE extends AddressedResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,M extends AddressedModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>> extends FileResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M> {

    protected final Specification specification;

    public AddressedResource(Function<R, R> graveDigger, M model, Specification specification,String name) {
        super(graveDigger, model,name);
        this.specification = specification;
    }
}
