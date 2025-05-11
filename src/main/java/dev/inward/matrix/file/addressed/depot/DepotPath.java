/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.depot;

public record DepotPath(String variantName, String... packageNames) implements Comparable<DepotPath> {

    @Override
    public int compareTo(DepotPath that) {
        int isZero = this.variantName.compareTo(that.variantName);
        if (isZero == 0) {
            for (int x = 0; x < packageNames.length; x++) {
                String thisPackageName = this.packageNames[x];
                String thatPackageName = that.packageNames[x];
                if (thisPackageName != null && thatPackageName != null) {
                    isZero = thisPackageName.compareTo(thatPackageName);
                    if (isZero != 0) {
                        break;
                    }
                }
                else if (thisPackageName == null) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        }
        return isZero;
    }
}
