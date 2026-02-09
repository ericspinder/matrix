/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Model;
import dev.inward.matrix.View;

import java.nio.file.WatchEvent;

public abstract class Bout<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M>> implements WatchEvent<Complication<TARGET,V,M>> {

    private final Complication<TARGET,V,M> complication;
    protected final

    public Bout(Complication<TARGET,V,M> complication) {
        this.complication = complication;
    }

    @Override
    public Kind<Complication<TARGET,V,M>> kind() {
        return this.complication.complicated;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Complication<TARGET,V,M> context() {
        return this.complication;
    }
}
