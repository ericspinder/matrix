package dev.inward.matrix.route;

import java.util.BitSet;

public interface Passage {
    BitSet getPassage();

    enum PassagePresets implements Passage {
        NEW(0, "Thread is new, not started"),
        COMPLETING(1, "Thread is working"),
        HOLD(2,"Waiting for work"),
        EXCEPTIONAL(3,"Exceptional"),
        CANCELLED(4,"Cancelled"),
        POOLED(6,"Pooled"),
        LOANED(7,"Loaned"),
        ;
        final BitSet stateId;
        final String description;
        PassagePresets(int n, String description) {
            this.stateId = new BitSet(n);
            this.description = description;
        }

        @Override
        public BitSet getPassage() {
            return stateId;
        }
        public boolean is(Passage passage) {
            return this.stateId.intersects(passage.getPassage());
        }

    }
}
