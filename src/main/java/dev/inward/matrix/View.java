/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.nio.file.attribute.AttributeView;

public abstract class View<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET>> implements AttributeView {

    protected final String name;
    protected final TARGET target;

    public View(String name, TARGET target) {
        this.name = name;
        this.target = target;
    }
    @Override
    public String name() {
        return null;
    }

    public TARGET getTarget() {
        return this.target;
    }
    public abstract M getModel();


}
