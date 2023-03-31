package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.authority.InternetClass;
import dev.inward.matrix.authority.ServerRecord;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;

public class SubjectMatter implements Comparable<SubjectMatter> {

    protected final Indicia indicia;
    protected final InternetClass internetClass;
    protected final Instant startInstant;
    protected final Instant endInstant;
    protected final ServerRecord[] serverRecords;

    public SubjectMatter(Indicia indicia, InternetClass internetClass, Instant startInstant, Instant endInstant, ServerRecord[] serverRecords) {
        this.indicia = indicia;
        this.internetClass = internetClass;
        this.startInstant = startInstant;
        this.endInstant = endInstant;
        this.serverRecords = serverRecords;
    }

    public Indicia getIndicia() {
        return indicia;
    }

    public InternetClass getInternetClass() {
        return internetClass;
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
            return this.internetClass.compareTo(that.internetClass);
        }
        return isZero;
    }
}
