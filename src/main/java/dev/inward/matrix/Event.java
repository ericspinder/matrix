/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.item.datum.indica.Indica;
import dev.inward.matrix.control.administration.Bureau;
import dev.inward.matrix.predictable.Executable;

import java.lang.ref.SoftReference;
import java.nio.file.WatchEvent;
import java.util.UUID;

public class Event<P extends Executable,B extends Bureau<?,?,?>> implements WatchEvent.Kind<P> {

    protected final UUID uuid;
    protected final Indica indica;
    protected final SoftReference<B> bureau;
    protected SoftReference<Class<P>> predictableClass;

    public Event(UUID uuid, Indica indica, B bureau) {
        this.uuid = uuid;
        this.indica = indica;
        this.bureau = new SoftReference<>(bureau);
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public Class<P> type() {
        return (Class<P>) indica.getKey().type();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public Indica getIndica() {
        return indica;
    }
    public B getBureau() {
        return bureau.get();
    }
}
