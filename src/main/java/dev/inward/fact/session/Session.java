package dev.inward.fact.session;

import dev.inward.fact.Fact;
import dev.inward.fact.Gate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Session<C extends SessionCrud, G extends Gate<?>> extends Fact<G> {

}
