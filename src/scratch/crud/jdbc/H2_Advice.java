/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.jdbc;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.advisor.advice.Advice;
import dev.inward.matrix.Recommendation;
import dev.inward.matrix.operational.Operational;

import java.sql.Connection;

public class H2_Advice<O extends Operational<Connection>,W extends Datum<Connection>> extends Advice<Connection,O,W> {

    public H2_Advice(O operational) {
        super(operational);
    }

    @Override
    protected Recommendation parseSqlState(String sqlState) {
        if (sqlState != null) {
            if ("28000".equals(sqlState)) {
                return Recommendation.Authentication_Failover;
            }
        }
        return null;
    }

    @Override
    protected Recommendation addSocketTimeout() {
        return Recommendation.Close_Closable;
    }

    @Override
    protected Recommendation examineMessage(String message) {
        return Recommendation.Close_Closable;
    }
}
