/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.log;

import dev.inward.matrix.item.datum.indica.IndicaKey;
import dev.inward.matrix.personality.Session;

import java.time.Duration;
import java.time.Instant;

public class LogEntry implements Comparable<LogEntry> {

    public class LogEntryKey {
        protected final Instant createTime;
        protected final IndicaKey indicaKey;
        protected final Log.Severity severity;
        protected final Session session;
    }

    protected Duration duration;


}
