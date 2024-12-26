package dev.inward.matrix.code;

import dev.inward.matrix.Branch;

public class Path_ofCode implements Comparable<Path_ofCode> {

    public final Branch branch;
    public final String structure;
    public final String package_;

    public Path_ofCode(Branch branch, String structure, String aPackage) {
        this.branch = branch;
        this.structure = structure;
        this.package_ = aPackage;
    }

    public Branch getBranch() {
        return branch;
    }

    public String getStructure() {
        return structure;
    }

    public String getPackage() {
        return package_;
    }

    @Override
    public int compareTo(Path_ofCode that) {
        int isZero = this.branch.compareTo(that.branch);
        if (isZero == 0) {
            isZero = this.structure.compareTo(that.structure);
            if (isZero == 0) {
                return this.package_.compareTo(that.package_);
            }
        }
        return isZero;
    }
}
