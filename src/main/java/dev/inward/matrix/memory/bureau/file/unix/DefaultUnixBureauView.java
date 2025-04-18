/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.unix;

public class DefaultUnixBureauView extends UnixBureauView<DefaultUnixBureauKey,DefaultUnixBureau,DefaultUnixBureauView,DefaultUnixBureauModel,DefaultUnixBureauReference, DefaultUnixBureauLibrarian> {
    public DefaultUnixBureauView(String name, DefaultUnixBureau bureau, DefaultUnixBureauModel bureauModel) {
        super(name, bureau, bureauModel);
    }
}
