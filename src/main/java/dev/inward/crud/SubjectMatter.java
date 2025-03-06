/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud;

import dev.inward.matrix.Library;
import dev.inward.matrix.Range;
import dev.inward.matrix.file.addressed.dns.catalogRecord.CatalogRecord;
import dev.inward.matrix.engine.Zone;

public class SubjectMatter<PATH extends Comparable<PATH>> implements Comparable<SubjectMatter<PATH>> {

    protected final Library library;
    protected final Zone zone;
    protected final Range<PATH> range;
    protected final CatalogRecord<PATH>[] catalogRecords;

    public SubjectMatter(Library library, Range<PATH> range, CatalogRecord<PATH>[] catalogRecords) {
        this.library = library;
        this.range = range;
        this.catalogRecords = catalogRecords;
    }

    public Library getLibrary() {
        return library;
    }

    public Range<PATH> getRange() {
        return range;
    }

    public CatalogRecord<PATH>[] getIndexRecords() {
        return catalogRecords;
    }

}
