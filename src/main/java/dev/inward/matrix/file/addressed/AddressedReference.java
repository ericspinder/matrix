/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed;

import dev.inward.matrix.*;
import dev.inward.matrix.file.*;

public abstract class AddressedReference<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,ID extends Comparable<ID>,K extends AddressedKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,F extends Addressed<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,R extends AddressedReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,A extends AddressedAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,RESOURCE extends AddressedResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,M extends AddressedModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>> extends FileReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M> {

    public AddressedReference(F addressed, RESOURCE resource) {
        super(addressed, resource);
    }

}
