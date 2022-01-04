package com.notionds.dataSupplier.provider;

public enum Situation {
    Provider("Held by provider"),
    Updating("Bus is updating, this is a locked state against read or other writes until cleared"),
    Open("Open, held by client, normal operations encouraged"),
    Empty("Datum has had an error, advice to continue thread will allow current operations to finish"),
    Closed_Failure("Datum is expected to be garbage collected, do not hold or create new reference as that will interfere with expected operations"),
    Closed("Datum is expected to be garbage collected, do not hold or create new reference as that will interfere with expected operations"),
    ;
    final String description;
    Situation(String description) {
        this.description = description;
    }
}
