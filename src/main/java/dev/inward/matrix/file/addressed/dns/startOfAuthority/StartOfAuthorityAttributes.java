/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.addressed.dns.RRAttributes;

import java.util.Map;

public class StartOfAuthorityAttributes extends RRAttributes<StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityReference,StartOfAuthorityAttributes,StartOfAuthorityResource,StartOfAuthorityModel> {
    public StartOfAuthorityAttributes(Map<String, Model.InstanceValue> properties, long fileSize) {
        super(properties, fileSize);
    }
}
