/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;

import java.util.function.Function;

public class DirectoryGestalt<S extends Scheme<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,LK extends LibraryKey<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,L extends Library<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,LV extends LibraryView<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,LM extends LibraryModel<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,C extends Catalog<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,CV extends CatalogView<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,CM extends CatalogModel<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,DB extends DirectoryLibrarian<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,DK extends DirectoryKey<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,D extends Directory<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,DV extends DirectoryView<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,DM extends DirectoryModel<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,DR extends DirectoryReference<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>,DRESOURCE extends DirectoryGestalt<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE>> extends FileGestalt<S,LK,L,LV,LM,PATH,CK,C,CV,CM,DB,DK,D,DV,DM,DR,DRESOURCE,DB,DK,D,DV,DM,DR,DRESOURCE> {

    public DirectoryGestalt(Function<DR, DR> graveDigger, DM model, Class<DV> viewClass) {
        super(graveDigger, model,viewClass);
    }
}
