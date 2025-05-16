/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.authority;

import dev.inward.matrix.control.ControlView;
import dev.inward.matrix.file.directory.*;

import java.nio.file.attribute.FileAttributeView;

public class AuthorityView<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ControlView<Authority<DF,DK,DV,DM,DR,DL,PATH>, AuthorityView<DF,DK,DV,DM,DR,DL,PATH>, AuthorityModel<DF,DK,DV,DM,DR,DL,PATH>> implements FileAttributeView {
    public AuthorityView(String name, Authority<DF,DK,DV,DM,DR,DL,PATH> authority) {
        super(name, authority);
    }
}
