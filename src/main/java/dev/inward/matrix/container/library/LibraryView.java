/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.container.catalog.*;
import dev.inward.matrix.file.*;

import java.nio.file.attribute.FileAttributeView;

public class LibraryView<S extends Scheme<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LK extends LibraryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,L extends Library<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LV extends LibraryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LM extends LibraryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LR extends LibraryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LG extends LibraryGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,C extends Catalog<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CV extends CatalogView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CM extends CatalogModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CR extends CatalogReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CG extends CatalogGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DB extends DirectoryLibrarian<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DK extends DirectoryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,D extends Directory<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DV extends DirectoryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DM extends DirectoryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DR extends DirectoryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DG extends DirectoryGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>> extends View<L,LM> implements FileAttributeView {
    public LibraryView(String name, L library, LM libraryModel) {
        super(name, library,libraryModel);
    }
}
