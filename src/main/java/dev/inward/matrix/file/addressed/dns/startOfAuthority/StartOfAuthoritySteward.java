/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRSteward;

import java.util.function.Function;

public class StartOfAuthoritySteward extends RRSteward<StartOfAuthorityLibrarian,StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference, StartOfAuthoritySteward> {

    public StartOfAuthoritySteward(Function<StartOfAuthorityReference, StartOfAuthorityReference> graveDigger, StartOfAuthorityModel model, Class<StartOfAuthorityView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
