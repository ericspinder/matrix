package dev.inward.matrix.fact.notion.concept;


import dev.inward.matrix.domain.Domain;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Gathering extends SoftReference<Domain> {

    public Gathering(Domain domain, ReferenceQueue<Domain> referenceQueue) {
        super(domain,referenceQueue);
    }

}
