/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

public record LogPath(String locus, long series, String computerName, String domainName) implements Comparable<LogPath> {

    @Override
    public int compareTo(LogPath that) {
        int isZero = this.locus.compareTo(that.locus);
        if (isZero == 0) {
            if (this.series == 0 && that.series == 0) {
                return isZero;
            }
            if (this.series == 0) {
                return 1;
            }
            if (that.series == 0) {
                return -1;
            }
            isZero = Long.compare(this.series,that.series);
            if (isZero == 0) {
                if (this.computerName == null && that.computerName == null) {
                    return isZero;
                }
                if (this.computerName == null) {
                    return 1;
                }
                if (that.computerName == null) {
                    return -1;
                }
                return this.computerName.compareTo(that.computerName);
            }
        }
        return isZero;
    }

    @Override
    public String toString() {
        return "/" + locus + "/" + ((series !=0)? series + "/" + ((computerName != null)? computerName + "/":""):"");
    }
}
