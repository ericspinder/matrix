

/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.phenomenon;

import dev.inward.matrix.file.FileContext;
import dev.inward.matrix.concept.file.addressed.depot.indica.IndicaKey;

import java.time.Instant;
import java.util.UUID;

public class SystemInitialization extends Autopsy<SystemInitialization, Identity.Ghost, FileContext.Ethereal> {

    public SystemInitialization(UUID uuid, Identity.Ghost ghost, Instant createInstant, IndicaKey indicaKey) {
        super(uuid, ghost, createInstant, indicaKey);
    }
}
