/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.domain;

import dev.inward.matrix.control.ControlReference;

public class DomainReference extends ControlReference<Domain,DomainView,DomainModel,DomainReference, DomainLibrarian> {
    public DomainReference(Domain referent, DomainLibrarian gestalt) {
        super(referent, gestalt);
    }
}
