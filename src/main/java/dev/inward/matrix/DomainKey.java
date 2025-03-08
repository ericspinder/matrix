/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.net.URI;

public class DomainKey extends MatrixKey<String,DomainKey,Domain> {

    public DomainKey(String domain) {
        super(URI.create("d://%s".formatted(domain)));
    }
}
