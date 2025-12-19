/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.platform.windows;

import dev.inward.matrix.concept.catalog.platform.PlatformView;

public class WindowsView extends PlatformView<Windows, WindowsView,WindowsBureauModel> {

    public WindowsView(Windows bureau) {
        super("Windows Bureau View", bureau);
    }
}
