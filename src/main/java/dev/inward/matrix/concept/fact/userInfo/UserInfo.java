/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.userInfo;

import dev.inward.matrix.concept.fact.Fact;

import java.lang.ref.Reference;

public abstract class UserInfo<F extends UserInfo<F,K,V,M,R,L,X>,K extends UserInfoKey<F,K,V,M,R,L,X>,V extends UserInfoView<F,K,V,M,R,L,X>,M extends UserInfoModel<F,K,V,M,R,L,X>,R extends Reference<F> & UserInfoReference<F,K,V,M,R,L,X>,L extends UserInfoLibrarian<F,K,V,M,R,L,X>,X extends UserInfoContext<F,K,V,M,R,L,X>> extends Fact<F,K,V,M,R,L,X> {
    protected UserInfo(K key) {
        super(key);
    }
}
