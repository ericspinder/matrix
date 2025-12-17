/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.time.Instant;

public class Experience<E extends Experience<E,EV,EM>,EV extends ExperienceView<E,EV,EM>,EM extends EventModel<E,EV,EM>> {

    public enum Grade {
        IMPORTANT,
        CONTRACTURAL,
        USEFUL,
        CASHED,
        LEFTOVER,
        EXPIRED;
        public static final Grade[] VALUES = values();
    }
    private Instant createInstant;
    private Instant lastGradingInstant;
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public Instant getLastGradingInstant() {
        return lastGradingInstant;
    }
    public void setLastGradingInstant(Instant lastGradingInstant) {
        this.lastGradingInstant = lastGradingInstant;
    }
    public Instant getCreateInstant() {
        return createInstant;
    }
}
