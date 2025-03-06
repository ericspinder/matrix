/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

public record LogPath(String locus, String computerName, long series) implements Comparable<LogPath> {

    @Override
    public int compareTo(LogPath that) {
        int isZero = this.locus.compareTo(that.locus);
        if (isZero == 0) {
            return Long.compare(this.series,that.series);
        }
        return isZero;
    }

    @Override
    public String toString() {
        return "Path_ofLog{" + "locus='" + locus + '\'' +
                ", computerName" + computerName + '\'' +
                ", series='" + series + '\'' +
                '}';
    }

    public String getPath() {
        return "/" + locus + "/" + computerName + "/" + series;
    }
}
