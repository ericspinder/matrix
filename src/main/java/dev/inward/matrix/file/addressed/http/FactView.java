/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.AddressedView;

public class FactView<F extends Fact<F,K,V,M,R,L>,K extends FactKey<F,K,V,M,R,L>,V extends FactView<F,K,V,M,R,L>,M extends FactModel<F,K,V,M,R,L>,R extends FactReference<F,K,V,M,R,L>,L extends FactLibrarian<F,K,V,M,R,L>> extends AddressedView<F,String,K,V,M,R,L,HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference,HttpDirectoryLibrarian,String> {

    public FactView(String name, F f) {
        super(name, f);
    }
}
