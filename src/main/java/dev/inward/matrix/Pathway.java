package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;
import dev.inward.matrix.concept.matter.Indicia;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class Pathway<S extends Scheme<S,L>,L extends Library<S,L>, P extends Pathway<S,L,P>> implements Comparable<P> {

    protected final L library;

    public Pathway(L library) {
        this.library = library;
    }

    public abstract String getPathString();

    @Override
    public int compareTo(P that) {
        int isZero = this.library.compareTo(that.library);
        if (isZero == 0) {
            return this.getPathString().compareTo(that.getPathString());
        }
        return isZero;
    }
    public static class Dogma extends Pathway<Scheme.Dogma, Library.Dogma,Dogma> {

        public Dogma(Library.Dogma library) {
            super(library);
        }

        @Override
        public String getPathString() {
            return null;
        }

    }
    public static class LogPathway extends Pathway<Scheme.Log, Library.Log,LogPathway> {

        protected final Indicia indicia;
        protected String pathTime;

        public LogPathway(Library.Log library, Indicia indicia, Instant rawPathTime) {
            this(library,indicia,rawPathTime,DateTimeFormatter.ofPattern("yyyy_MM_dd").withZone(ZoneId.systemDefault()));
        }
        public LogPathway(Library.Log library, Indicia indicia, Instant rawPathTime, DateTimeFormatter dateTimeFormatter) {
            super(library);
            this.indicia = indicia;
            this.pathTime = dateTimeFormatter.format(rawPathTime);
        }

        @Override
        public String getPathString() {
            return null;
        }
    }


    public static class DNSPathway extends Pathway<Scheme.DNS, Library.DNS,DNSPathway> {

        protected final Domain domain;
        protected final ResourceRecordType resourceRecordType;
        public DNSPathway(Library.DNS library, Domain domain, ResourceRecordType resourceRecordType) {
            super(library);
            this.domain = domain;
            this.resourceRecordType = resourceRecordType;
        }

        @Override
        public String getPathString() {
            return this.domain.toString() + '_' + this.resourceRecordType.toString();
        }

        public Domain getDomain() {
            return domain;
        }

        public ResourceRecordType getResourceRecordType() {
            return resourceRecordType;
        }
    }
}
