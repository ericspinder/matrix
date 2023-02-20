package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;

public class SubjectMatter implements Comparable<SubjectMatter> {

    protected final Indicia indicia;
    protected final InternetClass internetClass;
    protected final Instant startInstant;
    protected final Instant endInstant;
    protected final Server[] servers;

    public SubjectMatter(Indicia indicia, InternetClass internetClass, Instant startInstant, Instant endInstant, Server[] servers) {
        this.indicia = indicia;
        this.internetClass = internetClass;
        this.startInstant = startInstant;
        this.endInstant = endInstant;
        this.servers = servers;
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

    public Server[] getServers() {
        return servers;
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
