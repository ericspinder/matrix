package dev.inward.matrix;

import dev.inward.matrix.fact.matter.Exceptionally;
import dev.inward.matrix.fact.matter.Indicia;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

public class CheckedException extends IOException implements Exceptionally {

    protected final UUID uuid;
    protected final Indicia indicia;
    protected final Context context;

    public CheckedException(@Nonnull UUID uuid, @Nonnull Indicia indicia, @Nullable Context context, @Nullable Exception e) {
        super(e);
        this.uuid = uuid;
        this.indicia = indicia;
        this.context = context;
    }
    @Override
    public UUID getId() {
        return this.uuid;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uuid).append(indicia.toString());
        if (context != null) {
            return stringBuilder.append(context.toString()).toString();
        }
        return stringBuilder.append("[No context available]").toString();
    }

    @Override
    public Indicia getIndicia() {
        return null;
    }
}
