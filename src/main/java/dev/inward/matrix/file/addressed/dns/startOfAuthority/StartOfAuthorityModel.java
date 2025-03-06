/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.dns.RRModel;

public class StartOfAuthorityModel extends RRModel<StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityReference,StartOfAuthorityAttributes,StartOfAuthorityResource,StartOfAuthorityModel> {
    public StartOfAuthorityModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }
}
