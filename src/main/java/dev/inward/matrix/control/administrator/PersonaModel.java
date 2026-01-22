/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.administrator;

import dev.inward.matrix.Aspect;

public class PersonaModel extends AdministratorModel<Persona,PersonaView,PersonaModel,PersonaClerk> {
    public PersonaModel(Aspect[] labeledAspects) {
        super(Persona.class, labeledAspects);
    }
}
