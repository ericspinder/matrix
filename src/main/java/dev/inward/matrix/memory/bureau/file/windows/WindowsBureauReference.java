/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.file.windows;

import dev.inward.matrix.bureau.file.FileBureauReference;

public class WindowsBureauReference extends FileBureauReference<WindowsBureauKey,WindowsBureau,WindowsBureauView,WindowsBureauModel,WindowsBureauReference,WindowsBureauGestalt> {
    public WindowsBureauReference(WindowsBureau referent, WindowsBureauGestalt gestalt) {
        super(referent, gestalt);
    }
}
