package dev.inward.matrix.crud.jdbc;

import com.notionds.dataSupplier.datum.Datum;
import dev.inward.matrix.crud.Advice;
import dev.inward.matrix.Recommendation;
import com.notionds.dataSupplier.operational.Operational;

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
