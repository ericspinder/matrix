/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.depot;

public record DepotPath(String variantName, String fount) implements Comparable<DepotPath> {

    @Override
    public int compareTo(DepotPath that) {
        int isZero = this.variantName.compareTo(that.variantName);
        if (isZero == 0) {
            return this.fount.compareTo(that.fount);
        }
        return isZero;
    }
}
