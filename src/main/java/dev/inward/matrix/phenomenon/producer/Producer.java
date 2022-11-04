package dev.inward.matrix.phenomenon.producer;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Indicia;
import dev.inward.matrix.phenomenon.Phenomenon;

import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.concurrent.Future;

public abstract class Producer<PRODUCT,W extends Producer<PRODUCT,W>> extends Phenomenon<W> implements Future<PRODUCT> {

    protected SoftReference<PRODUCT> product;


    public Producer(Context.Demarc ethereal, Instant createInstant, String locus) {
        super(uuid, containerId, createInstant, new Indicia(locus, Indicia.Focus.Assembly, Indicia.Severity.Nominal));

    }


}