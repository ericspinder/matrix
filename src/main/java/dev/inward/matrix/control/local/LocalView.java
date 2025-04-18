/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.local;

import dev.inward.matrix.control.ControlView;

public class LocalView extends ControlView<Local,LocalView,LocalModel,LocalReference,LocalLibrarian> {
    public LocalView(String name, Local local, LocalReference reference) {
        super(name, local, reference);
    }
}
