/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class PrincipalLookupService extends UserPrincipalLookupService {


    @Override
    public UserPrincipal lookupPrincipalByName(String name) throws IOException {
        return null;
    }

    @Override
    public GroupPrincipal lookupPrincipalByGroupName(String group) throws IOException {
        return null;
    }
}
