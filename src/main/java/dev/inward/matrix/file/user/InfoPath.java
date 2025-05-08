/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;


public record InfoPath(String privilegeName, String functionName) implements Comparable<InfoPath> {

    @Override
    public int compareTo(InfoPath that) {
        int isZero = this.privilegeName.compareTo(that.privilegeName);
        if (isZero == 0) {
            return this.functionName.compareTo(that.functionName);
        }
        return isZero;
    }

    @Override
    public String toString() {
        return '/' + privilegeName + '/' + ((functionName != null)?functionName + '/':"");
    }
}
