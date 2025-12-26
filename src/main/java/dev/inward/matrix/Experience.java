/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.time.Instant;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Experience<E extends Experience<E,EV,EM>,EV extends ExperienceView<E,EV,EM>,EM extends ExperienceModel<E,EV,EM>> {

    public enum Grade {
        IMPORTANT,
        CONTRACTURAL,
        USEFUL,
        CASHED,
        LEFTOVER,
        EXPIRED;
        public static final Grade[] VALUES = values();
    }
    protected final Instant createInstant = Instant.now();
    private Grade grade;
    private final Map<Instant, Grade> gradingHistory = new TreeMap<>(NEWEST_ON_TOP_COMPARATOR);

    public Grade getGrade() {
        return grade;
    }
    public Instant getLastGradingInstant() {
        if(this.gradingHistory.isEmpty()) {
            return null;
        }
        return this.gradingHistory.entrySet().iterator().next().getKey();
    }
    public Instant getCreateInstant() {
        return createInstant;
    }

    @SuppressWarnings("unchecked")
    public E withGrade(Grade grade) {
        this.gradingHistory.put(Instant.now(), this.grade);
        this.grade = grade;
        return (E) this;
    }
    private static final Comparator<Instant> NEWEST_ON_TOP_COMPARATOR = new NewestOnTopComparator();
    private static class NewestOnTopComparator implements Comparator<Instant> {
        @Override
        public int compare(Instant o1, Instant o2) {
            return o2.compareTo(o1);
        }
    }

    public static class LibraryEx extends Experience<LibraryEx, LibraryExView, LibraryExModel> {
        private final Map<Instant,Integer> sizeHistory = new TreeMap<>(NEWEST_ON_TOP_COMPARATOR);

    }
    public static class LibraryExView extends ExperienceView<LibraryEx, LibraryExView, LibraryExModel> {

    }
    public static class LibraryExModel extends ExperienceModel<LibraryEx, LibraryExView, LibraryExModel> {

    }


}
