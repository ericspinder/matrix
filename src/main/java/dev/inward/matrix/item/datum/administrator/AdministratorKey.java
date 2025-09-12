/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.administrator;

import dev.inward.matrix.file.FileKey;
import dev.inward.matrix.file.FileReference;

import java.net.URI;

public class AdministratorKey<F extends Administrator<F,K,V,M,R,L>,K extends AdministratorKey<F,K,V,M,R,L>,V extends AdministratorView<F,K,V,M,R,L>,M extends AdministratorModel<F,K,V,M,R,L>,R extends FileReference,L extends AdministratorClerk<F,K,V,M,R,L>> extends FileKey<F,K,V,M,R,L> {

    protected final String userName;

    protected AdministratorKey(URI uri, String userName) {
        super(uri);
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

    public static abstract class Builder<F extends Administrator<F,K,V,M,R,L>,K extends AdministratorKey<F,K,V,M,R,L>,V extends AdministratorView<F,K,V,M,R,L>,M extends AdministratorModel<F,K,V,M,R,L>,R extends FileReference,L extends AdministratorClerk<F,K,V,M,R,L>> extends FileKey.Builder<F,K,V,M,R,L> {
        protected String userName;

        public Builder<F,K,V,M,R,L> setUserName(String userName) {
            this.userName = userName;
            return this;
        }
    }
}
