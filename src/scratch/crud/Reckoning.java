/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;

import dev.inward.matrix.meta.Meta;

import java.io.Serializable;

public abstract class Reckoning<S extends Reckoning<S>> extends Meta<S> implements Comparable<S>, Serializable {

    public Reckoning(String label, String description, String i18n, S defaultValue) {
        super(label, description, i18n, defaultValue);
    }

    /**
     * 
     * @return
     */
    public abstract Boolean isGoodThing();
}
