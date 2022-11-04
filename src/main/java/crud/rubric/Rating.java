package crud.rubric;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class Rating<I extends Identity<I,X>,X extends Context<X>,M extends Matter<I,X,M>> extends Matter<I,X,M> {

    public Rating(UUID uuid, I topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
