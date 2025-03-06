/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud.operational;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

public enum StandardsOptions implements Specification.DefaultOption<StandardsOptions,StandardsOptions> {
    ;

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public StandardsOptions getDefaultValue() {
        return null;
    }
}
