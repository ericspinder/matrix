package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.operational.induction.NotionProtectionDomain;
import dev.inward.matrix.operational.Operational;

public abstract class Builder<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X>,U extends Builder<Y,U,W,F,O,I,X,B,P>,F extends Fact<F,I,X>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> extends Resource<Y,F,W,B,> {
    /**
     * @param notionProtectionDomain
     * @noinspection Intellij
     */
    public Builder(NotionProtectionDomain notionProtectionDomain) {
        super(notionProtectionDomain);
    }
}> {
}
