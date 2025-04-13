/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Aspect;

public class PersonaModel extends PrivilegeModel<PersonaLibrarian,PersonaKey,Persona,PersonaView,PersonaModel,PersonaReference, PersonaSteward> {
    public PersonaModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
