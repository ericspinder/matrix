/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import java.net.URI;

public class AgentKey extends PrivilegeKey<AgentLibrarian,AgentKey,Agent,AgentView,AgentModel,AgentReference, AgentSteward> {
    protected AgentKey(URI uri, String s, InfoDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }
}
