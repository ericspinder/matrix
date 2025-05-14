/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory.bureau;

import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.addressed.*;
import dev.inward.matrix.file.user.Persona;
import dev.inward.matrix.control.memory.Memory;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
import java.nio.file.attribute.FileAttributeView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Bureau<BC extends Bureau<BC,BV,BM>,BV extends BureauView<BC,BV,BM>,BM extends BureauModel<BC,BV,BM>> extends Memory<BC,BV,BM> {



    @SuppressWarnings("unchecked")
    public Bureau(String name, boolean readOnly, Map<String,Object> attributes, Class<FileView<?,?,?,?,?,?>>[] supportedFileViews) {
        super(name, readOnly, attributes,supportedFileViews);

    }

    public abstract <F extends Addressed<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,ID extends Comparable<ID>,K extends AddressedKey<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,V extends AddressedView<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,M extends AddressedModel<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,R extends AddressedReference<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,L extends AddressedLibrarian<F,ID,K,V,M,R,L,DF,DK,DV,DM,DR,DL,PATH>,DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> F getFile(K key, Persona persona);




}