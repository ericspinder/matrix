package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.meta.Meta_I;

public enum Phase implements Meta_I<Phase,Phase> {
    Initialization("Initialization", "initialization"),
    Preparatory("Container", "Matter is the initialization of the Datum with the container"),
    Lucid("Lucid", "An operational matter"),
    Change("Change", "Phase Change, represents a lock while a change is made"),
    Stored("Stored", "Datum is stored, unless authoritative, this is a cold phase and not queued for updates, intended for long term storage and reintegration"),
    Suspect("Suspect", "Datum is suspect"),
    Expired("Expired", "Datum is past the refresh with no intention to try again, intended for long term storage without reintegration as a function"),
    Manic("Manic","Datum is exceptionally problematic"),
    Cleanup("Cleanup", "On cleanup, during garbage collection"),
    Shutdown("Shutdown", "On shutdown"),
    ;
    private final String label;
    private final String description;

    Phase(String label, String description) {
        this.label = label;
        this.description = description;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}
