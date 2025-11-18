/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.terrene;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.util.UUID;

public class Luna extends Terrene {

    public Luna() {
        super("LU", "Luna");
    }

    @Override
    public UUID getUuid() {
        return null;
    }

    @Override
    public Instant getCreateInstant() {
        return null;
    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return null;
    }
}
