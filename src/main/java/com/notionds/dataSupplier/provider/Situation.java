package com.notionds.dataSupplier.provider;

public enum Situation {
    Unconditioned("Needs conditioning"),
    Provider("Held by provider"),
    Updating("Notion is updating"),
    Open("Open, held by client, normal operations encouraged"),
    Empty("Notion has had an error, advice to continue thread will allow current operations to finish"),
    Closed_Failure("Notion is closed due to failure, do not hold or create new reference as that will interfere with normal garbage collection"),
    Closed("Notion is closed, do not hold or create new reference as that will interfere with normal garbage collection"),
    ;
    final String description;
    Situation(String description) {
        this.description = description;
    }
}
