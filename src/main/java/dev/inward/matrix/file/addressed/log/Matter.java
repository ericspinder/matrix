/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.depot.indica.IndicaKey;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public abstract class Matter extends Addressed<LogScheme,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference,LogCatalogLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian,UUID,MatterKey,Matter,MatterView,MatterModel,MatterReference,MatterLibrarian> {

    protected final Instant createTime;
    protected final IndicaKey indicaKey;
    protected final Severity severity;

    protected Duration duration;

    public Matter(MatterKey key, IndicaKey indicaKey, Severity severity) {
        this(key, indicaKey,severity,Instant.now());
    }
    public Matter(MatterKey id, IndicaKey indicaKey, Severity severity, Instant createTime) {
        super(id);
        this.indicaKey = indicaKey;
        this.severity = severity;
        this.createTime = createTime;
    }

    public enum Severity implements Meta_I {
        Critical("critical", "Code related problem of primary importance"),
        Trace("trace", "Asked for by Owner", 1000),
        Privilege("privilege", "A seemingly proper use of a critical component", 10),
        Violation("violation", "An improper use of a critical component"),
        Capacity("capacity", "Capacity has been exceeded", 200),
        Norminal("norminal", "An operation which is both nominal and normal, the completely expected result", 1000),
        Timer("timer", "Something which affects normal operation of a timer"),
        Exceptional("exceptional", "An exception was thrown which has not be categorized otherwise");
        private final String label;
        private final String description;
        private final int autoSettleDefault;

        Severity(String label, String description) {
            this(label, description, 1);
        }

        Severity(String label, String description, int autoSettleDefault) {
            this.label = label;
            this.description = description;
            this.autoSettleDefault = autoSettleDefault;
        }

        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getDescription() {
            return description;
        }

        public long getAutoSettleDefault() {
            return autoSettleDefault;
        }
    }
}
