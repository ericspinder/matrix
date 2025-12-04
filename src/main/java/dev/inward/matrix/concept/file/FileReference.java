/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file;

import dev.inward.matrix.Context;
import dev.inward.matrix.Bus;

public interface FileReference<F extends File<F,K,V,M,R,L,C>,K extends FileKey<F,K,V,M,R,L,C>,V extends FileView<F,K,V,M,R,L,C>,M extends FileModel<F,K,V,M,R,L,C>,O extends OmniBus<F,K,V,M,R,L,C>,L extends Librarian<F,K,V,M,R,L,C>,C extends Context<F,V,M,L,C>> extends Bus<F> {




}
