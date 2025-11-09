/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.platform.windows;

import dev.inward.matrix.catalog.platform.PlatformBureauView;

public class WindowsBureauView extends PlatformBureauView<WindowsBureau,WindowsBureauView,WindowsBureauModel> {

    public WindowsBureauView(WindowsBureau bureau) {
        super("Windows Bureau View", bureau);
    }
}
