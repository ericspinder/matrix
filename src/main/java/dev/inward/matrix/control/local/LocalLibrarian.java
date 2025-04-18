/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.local;

import dev.inward.matrix.control.ControlLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class LocalLibrarian extends ControlLibrarian<Local,LocalView,LocalModel,LocalReference,LocalLibrarian> {
    public LocalLibrarian(Standard standard) {
        super(standard);
    }
}
