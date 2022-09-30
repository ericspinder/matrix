package dev.inward.matrix.resources;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public abstract class ResourceQueue_forNotion<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>,N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>> extends ReferenceQueue<DATUM> {

    protected

}
