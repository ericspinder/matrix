/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.personality;

import dev.inward.matrix.Materialization;

import java.security.Permission;
import java.security.Principal;

public class Session implements Principal {

    protected final

    public Session(String name, Identity.Gate gate) {
        super(name);
        this.gate = gate;
    }


}
