/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.realm;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.authority.Authority;

public class RealmAuthority extends Authority<RealmScheme, RealmAuthority,String> {

    public RealmAuthority(RealmScheme scheme, Domain domain) {
        super(scheme, domain);
    }

}
