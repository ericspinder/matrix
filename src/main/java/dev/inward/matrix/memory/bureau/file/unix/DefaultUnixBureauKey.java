/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.unix;

import java.net.URI;

public class DefaultUnixBureauKey extends UnixBureauKey<DefaultUnixBureauKey,DefaultUnixBureau,DefaultUnixBureauView,DefaultUnixBureauModel,DefaultUnixBureauReference, DefaultUnixBureauLibrarian> {
    protected DefaultUnixBureauKey(URI uri) {
        super(uri);
    }
}
