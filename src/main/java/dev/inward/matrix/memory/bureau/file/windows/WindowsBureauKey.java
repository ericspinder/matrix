/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.windows;

import dev.inward.matrix.memory.bureau.file.FileBureauKey;

import java.net.URI;

public class WindowsBureauKey extends FileBureauKey<WindowsBureauKey,WindowsBureau,WindowsBureauView,WindowsBureauModel,WindowsBureauReference, WindowsBureauSteward> {
    protected WindowsBureauKey(URI uri) {
        super(uri);
    }
}
