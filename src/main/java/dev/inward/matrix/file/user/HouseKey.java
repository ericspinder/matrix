/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import java.net.URI;

public class HouseKey extends PrivilegeKey<House,HouseKey,HouseView,HouseModel,HouseReference,HouseLibrarian> {
    protected HouseKey(URI uri, String s) {
        super(uri, s);
    }
}
