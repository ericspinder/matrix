package dev.inward.matrix.path;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Edition;
import dev.inward.matrix.datum.fact.test.Test;

import java.io.Serializable;


public abstract class Path<X extends Path<X>> extends Context<X> implements Comparable<X>, Serializable {

    protected final char character;
    protected final String path;
    protected final Data<X> data;

    public static final class Nominal extends Path<Nominal> {

        public Nominal(Edition edition, char character, String path, Data<Nominal> data) {
            super(edition,true, character, path,data);
        }
    }
    public static class Mock<T extends Test> extends Path<Mock<T>> {

        protected T test;

        public Mock(Edition edition, String path, final char character, Data<Mock<T>> data,T test) {
            super(edition, false, character, path, data);
            this.test = test;
        }

        public T getTest() {
            return test;
        }

        @Override
        public int compareTo(Mock<T> that) {
            int isZero = super.compareTo(that);
            if (isZero == 0) {
                isZero = this.test.compareTo(that.test);
            }
            return isZero;
        }

    }


    public Path(Edition edition, boolean production, final char character, final String path, final Data<X> data) {
        super(edition, production);
        this.character = character;
        this.path = path;
        this.data = data;
    }

    @Override
    public int compareTo(X that) {
        int isZero = super.compareTo(that);
        if (isZero == 0) {
            return java.lang.Character.compare(this.character,that.character);
        }
        return isZero;
    }



}