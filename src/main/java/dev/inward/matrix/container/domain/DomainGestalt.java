/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DomainGestalt extends Gestalt<Domain,DomainView,DomainModel,DomainReference,DomainGestalt> {
    public DomainGestalt(Standard standard) {
        super(standard);
    }
}
