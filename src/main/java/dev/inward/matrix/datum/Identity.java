package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

public abstract class Identity<I extends Identity<I,X>,X extends Context<X>> implements Comparable<I>, Serializable {

    public static final char Empty = '\u0000';

    protected final char persona;
    protected final X context;

    public Identity(char persona, X context) {
        this.persona = persona;
        this.context = context;
    }

    public final X getContext() {
        return this.context;
    }

    @Override
    public int compareTo(I that) {
        int isZero = this.context.compareTo(that.context);
        if (isZero == 0) {
            return this.persona - that.persona;
        }
        return isZero;
    }

    public static class Id extends Identity<Id, Context.Service> {

        protected final SuperEgo superEgo;
        protected String path;
        public Id(char persona, Context.Service context, SuperEgo superEgo, String path) {
            super(persona, context);
            this.superEgo = superEgo;
            this.path = path.substring(this.getContext().getIndex().length);
        }
        public SuperEgo getSuperEgo() {
            return superEgo;
        }
        public String getPath() {
            return path;
        }
        public String getCompetePath() {
            return Arrays.toString(this.getContext().getIndex()) + this.path;
        }
        @Override
        public int compareTo(Id that) {
            int isZero = this.superEgo.compareTo(that.superEgo);
            if (isZero == 0) {
                isZero = this.context.compareTo(that.context);
                if (isZero == 0) {
                    isZero = this.path.compareTo(that.path);
                    if (isZero == 0) {
                        return this.persona - that.persona;
                    }
                }
            }
            return isZero;
        }
    }
    public static class SuperEgo extends Identity<SuperEgo, Context.Service> {

        public SuperEgo(char persona, Context.Service context) {
            super(persona, context);
        }
    }
    public static final class Ego extends Identity<Ego,Context.Ethereal> {

        public final UUID uuid;

        public Ego(char persona, Context.Ethereal ethereal, UUID uuid) {
            super(persona,ethereal);
            this.uuid = uuid;
        }
        public Ego(char persona, Context.Ethereal ethereal) {
            this(persona,ethereal,UUID.randomUUID());
        }

        @Override
        public int compareTo(Ego that) {
            int isZero =  this.context.compareTo(that.context);
            if (isZero == 0) {
                isZero = this.persona - that.persona;
                if (isZero == 0) {
                    return this.uuid.compareTo(that.uuid);
                }
            }
            return isZero;
        }
    }
    public static final class Ghost extends Identity<Ghost,Context.Ethereal>  {
        public Ghost(Context.Ethereal ethereal) {
            super(Empty, ethereal);
        }

    }


}
