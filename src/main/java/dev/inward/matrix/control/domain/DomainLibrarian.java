/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.domain;

import dev.inward.matrix.control.ControlLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DomainLibrarian extends ControlLibrarian<Domain,DomainView,DomainModel,DomainReference, DomainLibrarian> {
    public DomainLibrarian(Standard standard) {
        super(standard);
    }
}
