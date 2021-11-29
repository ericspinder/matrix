package com.notionds.dataSupplier.provider;

public enum Situation {
    New_Unattached("New, still needs an open connection"),
    Provider("Held by provider"),
    Open("Open, held by client, normal operations allowed, even encouraged one may say"),
    Empty("Notion has had an error, will allow current operations to finish, but do not return to provider, next error may cause interruption of thread"),
    Closed_Failure("Notion is closed, do not reference object as it will interfere with normal garbage collection"),
    Closed("Notion is closed, do not reference object as it will interfere with normal garbage collection"),
    ;
    final String description;
    Situation(String description) {
        this.description = description;
    }
}
