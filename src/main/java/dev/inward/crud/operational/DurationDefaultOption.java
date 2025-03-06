/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud.operational;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public enum DurationDefaultOption implements Specification.DefaultOption<Duration, DurationDefaultOption> {

    ConnectionTimeoutInPool("dev.inward.source.connections_timeout_in_pool", "Amount of time connections will wait in the provider before reaping excess of the number of active in provider connections", Duration.of(20, ChronoUnit.MINUTES)),
    ConnectionTimeoutInPool_Cool_Down("dev.inward.source.connections_timeout_in_pool_cool_down", "Minimum amount of time between reaping extra active connections, this creates a walk down from the maximum number of connections", Duration.of(60, ChronoUnit.SECONDS)),
    ConnectionTimeoutOnLoan("dev.inward.source.connection_timeout_on_loan", "Default max time before connection is automatically closed, breaking loaned connections. Anything but a positive amount disables that function", Duration.of(3, ChronoUnit.MINUTES)),
    ConnectionMaxLifetime("dev.inward.source.connection_timeout_max_lifetime", "Max lifetime of a connection", Duration.of(2, ChronoUnit.HOURS)),
    RetrieveNewMember("dev.inward.source.retrieve_new", "The amount of time to wait for a new Member", Duration.of(3, ChronoUnit.SECONDS)),
    ;
    private final String label;
    private final String i18n;
    private final String description;
    private final Duration defaultValue;
    DurationDefaultOption(String i18n, String description, Duration defaultValue) {
        this.label = name();
        this.i18n = i18n;
        this.description = description;
        this.defaultValue = defaultValue;
    }
    public String getLabel() {
        return this.label;
    }
    public String getLabel() {
        return this.i18n;
    }
    public String getDescription() {
        return this.description;
    }
    public Duration getDefaultValue() {
        return this.defaultValue;
    }

    public @interface DurationDefault {

        DurationDefaultOption lowVariation();
        DurationDefaultOption value();
        DurationDefaultOption highVariation();

    }
}
