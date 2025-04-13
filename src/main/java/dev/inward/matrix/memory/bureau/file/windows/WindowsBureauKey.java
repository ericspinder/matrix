/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.file.windows;

import dev.inward.matrix.bureau.file.FileBureauKey;

import java.net.URI;

public class WindowsBureauKey extends FileBureauKey<WindowsBureauKey,WindowsBureau,WindowsBureauView,WindowsBureauModel,WindowsBureauReference,WindowsBureauGestalt> {
    protected WindowsBureauKey(URI uri) {
        super(uri);
    }
}
