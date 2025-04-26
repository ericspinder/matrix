/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.windows;

import dev.inward.matrix.memory.bureau.file.FileBureauView;

public class WindowsBureauView extends FileBureauView<WindowsBureau,WindowsBureauView,WindowsBureauModel,WindowsBureauReference,WindowsBureauLibrarian> {

    public WindowsBureauView(String name, WindowsBureau windowsBureau, WindowsBureauReference reference) {
        super(name, windowsBureau, reference);
    }
}
