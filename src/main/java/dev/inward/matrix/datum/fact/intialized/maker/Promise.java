package dev.inward.matrix.datum.fact.intialized.maker;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Indicia;

import java.lang.ref.SoftReference;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.*;

public abstract class Promise<P extends Promise<P,RESP,REQ,IC,XC>,RESP extends Response<RESP,IC,XC>,REQ extends Request<REQ,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> implements Future<RESP> {

    protected final UUID requestUUID;
    protected final IC requestedId;
    protected final Instant requestInstant;
    protected final Instant instantExpectedReady;
    protected final Duration durationAvailable;
    protected SoftReference<RESP> promised;

    public Promise(UUID requestUUID,IC requestedId,Instant requestInstant, Instant instantExpectedReady, Duration durationAvailable) {
        this.requestUUID = requestUUID;
        this.requestedId = requestedId;
        this.requestInstant = requestInstant;
        this.instantExpectedReady = instantExpectedReady;
        this.durationAvailable = durationAvailable;
    }

    public final UUID getRequestUUID() {
        return requestUUID;
    }

    public final IC getRequestedId() {
        return requestedId;
    }

    public final Instant getRequestInstant() {
        return requestInstant;
    }

    public final Instant getInstantExpectedReady() {
        return instantExpectedReady;
    }

    public final Duration getDurationAvailable() {
        return durationAvailable;
    }

    public final SoftReference<RESP> getPromised() {
        return promised;
    }
    public final void setPromised(SoftReference<RESP> promised) {
        if (this.promised == null) {
            this.promised = promised;
        }
        else {
            throw new NotionStartupException(NotionStartupException.Type.SoftReference_Problem,this.getClass(), Indicia.Focus.Type, Indicia.Severity.Exceptional,new Exception("Cannot set a Soft Reference twice"));
        }
    }
}
