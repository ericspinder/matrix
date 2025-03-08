/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.file.*;

import java.net.URI;

public class CatalogKey<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends MatrixKey<PATH,CK,C> {

    protected final L library;
    protected final Range<PATH> range;

    public CatalogKey(URI uri, L library, Range<PATH> range) {
        super(uri);
        this.library = library;
        this.range = range;
    }
    public L getLibrary() {
        return this.library;
    }
    public Range<PATH> getRange() {
        return range;
    }
    public static abstract class Builder<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> {

        protected URI uri;
        protected Range<PATH> range;

        public Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM> buildUri(L library, PATH startPath, PATH endPath, Zone zone) {
            StringBuilder sb = new StringBuilder();
            sb.append(library.getKey().getMatrixPath().toUri().toString());
            if (startPath != null || endPath != null) {
                sb.append('?');
                if (startPath != null) {
                    sb.append("startPath").append(startPath);
                    if (endPath == null) {
                        range = new Range.BelowPath<>(startPath);
                    }
                }
                if (endPath != null) {
                    sb.append("endPath").append(endPath);
                    if (startPath == null) {
                        range = new Range.AbovePath<>(endPath);
                    }
                }
                if (startPath != null && endPath != null) {
                    range = new Range.BetweenPaths<>(startPath,endPath);
                }

            }
            else {
                range = new Range.AllPaths<>();
            }
            if (zone != null) {
                sb.append('#').append(zone);
            }
            this.uri = URI.create(sb.toString());
            return this;
        }

        public abstract C createCatalogKey();
    }
}
