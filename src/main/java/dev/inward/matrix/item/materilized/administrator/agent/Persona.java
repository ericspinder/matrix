/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.materilized.administrator.agent;

import dev.inward.matrix.control.domain.Domain;

public class Persona extends Agent<Persona,PersonaView,PersonaModel,PersonaClerk> {

    public Persona(Domain domain, String name) {
        super(domain, name);
    }


}
