package dev.inward.matrix.datum;

import javax.security.auth.Subject;
import java.security.Permission;

public class Indicia extends Permission implements Comparable<Indicia> {

    protected final String magicWord;
    protected final Subject subject;
    protected final Short layer;

    public Indicia(String magicWord, Subject subject, Short layer) {
        this.magicWord = magicWord;
        this.subject = subject;
        this.layer = layer;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public int compareTo(Indicia that) {
        int isZero = this.layer.compareTo(that.layer);
        if (isZero == 0) {
            isZero = this.magicWord.compareTo(that.magicWord);
        }
        return isZero;
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getActions() {
        return null;
    }
}
