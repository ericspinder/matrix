/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRResource;

import java.util.function.Function;

public class StartOfAuthorityResource extends RRResource<StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityReference,StartOfAuthorityAttributes,StartOfAuthorityResource,StartOfAuthorityModel> {
    public StartOfAuthorityResource(Function<StartOfAuthorityReference, StartOfAuthorityReference> graveDigger, StartOfAuthorityModel model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
