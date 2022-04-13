package crud.driver;

import dev.inward.matrix.datum.Id;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.Root;

public class Driver extends Concept<Driver, Context., Root> {

    public Driver(Id.Ego<Driver, Context> id) {
        super(id);
    }
}
