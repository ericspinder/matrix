/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.windows;

import dev.inward.matrix.memory.bureau.file.FileBureauLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class WindowsBureauLibrarian extends FileBureauLibrarian<WindowsBureau,WindowsBureauView,WindowsBureauModel,WindowsBureauReference,WindowsBureauLibrarian> {
    public WindowsBureauLibrarian(Standard standard) {
        super(standard);
    }
}
