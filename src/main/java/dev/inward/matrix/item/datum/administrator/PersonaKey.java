/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.administrator;

import java.net.URI;
import java.net.URISyntaxException;

public class PersonaKey extends AdministratorKey<Persona,PersonaKey,PersonaView,PersonaModel, PersonaReferenceWeak, PersonaClerk> {
    protected PersonaKey(URI uri, String userName) {
        super(uri, userName);
    }

    public static class Builder extends AdministratorKey.Builder<Persona,PersonaKey,PersonaView,PersonaModel, PersonaReferenceWeak, PersonaClerk> {

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
