/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;


public class PersonaView extends PrivilegeView<PersonaKey,Persona,PersonaView,PersonaModel,PersonaReference,PersonaLibrarian> {

    public PersonaView(String name, Persona file, PersonaReference fileReference) {
        super(name, file, fileReference);
    }
}
