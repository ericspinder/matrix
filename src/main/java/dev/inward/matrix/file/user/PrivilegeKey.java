/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import dev.inward.matrix.file.FileKey;
import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;
import java.nio.file.Path;

public class PrivilegeKey<F extends Privilege<F,K,V,M,R,L>,K extends PrivilegeKey<F,K,V,M,R,L>,V extends PrivilegeView<F,K,V,M,R,L>,M extends PrivilegeModel<F,K,V,M,R,L>,R extends PrivilegeReference<F,K,V,M,R,L>,L extends PrivilegeLibrarian<F,K,V,M,R,L>> extends FileKey<F,K,V,M,R,L> {

    protected final String userName;

    protected PrivilegeKey(URI uri, String userName) {
        super(uri);
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

    public static abstract class Builder<F extends Privilege<F,K,V,M,R,L>,K extends PrivilegeKey<F,K,V,M,R,L>,V extends PrivilegeView<F,K,V,M,R,L>,M extends PrivilegeModel<F,K,V,M,R,L>,R extends PrivilegeReference<F,K,V,M,R,L>,L extends PrivilegeLibrarian<F,K,V,M,R,L>> extends FileKey.Builder<F,K,V,M,R,L> {
        protected String userName;

        public Builder<F,K,V,M,R,L> setUserName(String userName) {
            this.userName = userName;
            return this;
        }
    }
}
