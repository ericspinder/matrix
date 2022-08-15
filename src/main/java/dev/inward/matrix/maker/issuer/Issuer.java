package dev.inward.matrix.maker.issuer;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.sql.Connection;

public class Issuer<I extends Identity<I,X>,X extends Context<X>> extends Fact<Issuer<I,X>,I,X,Imprint> {
}
