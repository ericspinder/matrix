/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog;

import dev.inward.matrix.*;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.file.directory.*;

public class CatalogModel<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ControlModel<Catalog<DF,DK,DV,DM,DR,DL,PATH>,CatalogView<DF,DK,DV,DM,DR,DL,PATH>,CatalogModel<DF,DK,DV,DM,DR,DL,PATH>> {

    public CatalogModel(Aspect[] labeledAspects) {
        super(Catalog.class, labeledAspects);
    }
}
