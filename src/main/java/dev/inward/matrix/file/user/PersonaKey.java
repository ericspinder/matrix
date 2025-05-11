/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import java.net.URI;
import java.net.URISyntaxException;

public class PersonaKey extends PrivilegeKey<Persona,PersonaKey,PersonaView,PersonaModel,PersonaReference,PersonaLibrarian> {
    protected PersonaKey(URI uri, String userName) {
        super(uri, userName);
    }

    public static class Builder extends PrivilegeKey.Builder<Persona,PersonaKey,PersonaView,PersonaModel,PersonaReference,PersonaLibrarian> {

        @Override
        protected URI makeUri() throws URISyntaxException {
            return new URI(this.userName + "@" + this.);
        }

        @Override
        protected PersonaKey newMatrixKey() {
            return null;
        }
    }
}
