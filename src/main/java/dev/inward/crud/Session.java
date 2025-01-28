package dev.inward.crud;

import dev.inward.matrix.*;
import dev.inward.matrix.info.Agent;
import dev.inward.matrix.info.Gadget;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;

import java.time.Instant;
import java.time.Year;
import java.util.UUID;

public abstract class Session extends Gadget<> {
    protected final Instant createInstant;
    protected final UUID passepartout;
    protected Instant expire;
    protected Agent agent;
    protected final static char CurrentYear() {
        return Character.forDigit(Year.now().getValue() - 1992,10);
    }
    public static class Id<S extends Scheme<S,L>,L extends Library<S,L>> extends Gadget.Address<S,L, Agent<S,L>,Id<S,L>,Session<S,L>> {

        public Id(String s, UUID instance, Agent<S, L> dogma) {
            super(s, instance, dogma);
        }

    }

    public Session(UUID passepartout) {
        this(CurrentYear(),passepartout);
    }
    public Session(char year, UUID passepartout) {
        this.year = year;
        this.passepartout = passepartout;
    }

    public Instant getExpire() {
        return expire;
    }
    public boolean isExpired() {
        return this.expire.isBefore(Instant.now());
    }
    public final void setExpire(Instant expire) {
        if (Instant.now().isAfter(this.expire)) {
            this.expire = expire;
            return;
        }
        throw new MatrixException(MatrixException.Type.Cannot_Update_Session_Expire,"Session", Indicia.Focus.Regulatory, Indicia.Severity.Critical,new Exception());
    }

    @Override
    public int compareTo(Session<S,L> that) {
        int isZero = this.agent.compareTo(that.agent);
        if (isZero == 0) {
            isZero = this.year - that.year;
            if (isZero == 0) {
                isZero = this.passepartout.compareTo(that.passepartout);
            }
        }
        return isZero;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Session{");
        sb.append("year=").append(year);
        sb.append(", passepartout=").append(passepartout);
        sb.append(", expire=").append(expire);
        sb.append(", agent=").append(agent);
        sb.append('}');
        return sb.toString();
    }
}
