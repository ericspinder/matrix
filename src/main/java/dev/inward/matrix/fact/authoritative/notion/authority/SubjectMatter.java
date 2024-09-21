package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.Terrene;
import dev.inward.matrix.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.concept.matter.Indicia;

import java.time.Instant;

public class SubjectMatter implements Comparable<SubjectMatter> {

    protected final Indicia indicia;
    protected final Terrene terrene;
    protected final Instant startInstant;
    protected final Instant endInstant;
    protected final ServerRecord[] serverRecords;

    public SubjectMatter(Indicia indicia, Terrene terrene, Instant startInstant, Instant endInstant, ServerRecord[] serverRecords) {
        this.indicia = indicia;
        this.terrene = terrene;
        this.startInstant = startInstant;
        this.endInstant = endInstant;
        this.serverRecords = serverRecords;
    }

    public Indicia getIndicia() {
        return indicia;
    }

    public Terrene getInternetClass() {
        return terrene;
    }

    public Instant getStartInstant() {
        return startInstant;
    }

    public Instant getEndInstant() {
        return endInstant;
    }

    public ServerRecord[] getServers() {
        return serverRecords;
    }

    @Override
    public int compareTo(SubjectMatter that) {
        int isZero = this.indicia.compareTo(that.indicia);
        if (isZero == 0) {
            return this.terrene.compareTo(that.terrene);
        }
        return isZero;
    }
}
