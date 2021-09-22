package dev.inward.morph;

import dev.inward.fact.security.Security;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
@SuperBuilder
public  class CreationMorph<C extends CreationCrud, S extends Security> extends Morph<Instant, C, S> {

}
