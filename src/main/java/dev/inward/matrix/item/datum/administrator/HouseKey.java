/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.administrator;

import java.net.URI;

public class HouseKey extends AdministratorKey<House,HouseKey,HouseView,HouseModel, HouseReferenceWeak, HouseClerk> {
    protected HouseKey(URI uri, String s) {
        super(uri, s);
    }
}
