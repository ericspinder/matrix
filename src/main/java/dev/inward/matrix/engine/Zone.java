/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.engine;

import dev.inward.matrix.Meta_I;

/**
 * The Purpose of the Zone,
 */
public enum Zone implements Meta_I {
    InSitu("inSitu", "Represents the running system and is of the governance of the processes, synchronized with all remote inSitu systems"),
    Notary("notary", "designated as system of record and the transactional participant, a notary cannot be deleted in memory until expired"),
    Hoard("hoard", "non authoritative records of the indexed domain, which is not synced with authoritative systems"),
    Cache("cache", "non authoritative records of the indexed domain which is synced with authoritative systems"),
    Presentation("presentation", "used to offload read requests from InSitu servers"),
    Prompt("prompt", "Used for calculations"),
    ;
    public final String label;
    public final String desc;

    Zone(String label, String desc) {
        this.label = label;
        this.desc = desc;
    }
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getDescription() {
        return desc;
    }

}
