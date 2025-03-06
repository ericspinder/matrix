/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed;

import dev.inward.matrix.LibraryKey;
import dev.inward.matrix.file.File;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;

public abstract class Addressed<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends AddressedCatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends AddressedCatalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends AddressedDirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends AddressedDirectory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends AddressedDirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends AddressedDirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends AddressedDirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends AddressedDirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,ID extends Comparable<ID>,K extends AddressedKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,F extends Addressed<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,R extends AddressedReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,A extends AddressedAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,RESOURCE extends AddressedResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>,M extends AddressedModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,ID,K,F,R,A,RESOURCE,M>> extends File<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M> {

    public Addressed(K key) {
        super(key);
    }

//    interface Permit<P extends Permit<P,SUBJECT>,SUBJECT> extends Comparable<P> {
//
//        String PERMIT_PROPERTY = "permit";
//        UUID getUuid();
//        Dogma.Agent getOwner();
//        Dogma.House getHouse();
//
//        List<Rule> getRules();
//
//        boolean allowAccess(Dogma.Persona persona, AclEntryPermission requestedPermission);
//        void notify(Noted noted);
//        void process(Exception exception);
//    }
//
//    interface Noted {
//        String getNote();
//    }

}
