/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.log;

public record LogPath(String locus, String series, String domainName, String computerName) implements Comparable<LogPath> {

    @Override
    public int compareTo(LogPath that) {
        int isZero = this.locus.compareTo(that.locus);
        if (isZero == 0) {
            isZero = this.series.compareTo(that.series);
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
        return "/" + locus + "/" + series + "/" + domainName + "/" + computerName + "/";
    }
}
