package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.Library;
import dev.inward.matrix.Range;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.dns.resourceRecord.IndexRecord;
import dev.inward.matrix.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.engine.Zone;

import java.time.Instant;

public class SubjectMatter<PATH extends Comparable<PATH>> implements Comparable<SubjectMatter<PATH>> {

    protected final Library library;
    protected final Zone zone;
    protected final Range<PATH> range;
    protected final IndexRecord<PATH>[] indexRecords;

    public SubjectMatter(Library library, Range<PATH> range, IndexRecord<PATH>[] indexRecords) {
        this.library = library;
        this.range = range;
        this.indexRecords = indexRecords;
    }

    public Library getLibrary() {
        return library;
    }

    public Range<PATH> getRange() {
        return range;
    }

    public IndexRecord<PATH>[] getIndexRecords() {
        return indexRecords;
    }

}
