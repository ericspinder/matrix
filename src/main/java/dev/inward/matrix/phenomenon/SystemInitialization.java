

/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.phenomenon;

import dev.inward.matrix.Context;
import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;

import java.time.Instant;
import java.util.UUID;

public class SystemInitialization extends Autopsy<SystemInitialization, Identity.Ghost, Context.Ethereal> {

    public SystemInitialization(UUID uuid, Identity.Ghost ghost, Instant createInstant, IndiciaKey indiciaKey) {
        super(uuid, ghost, createInstant, indiciaKey);
    }
}
