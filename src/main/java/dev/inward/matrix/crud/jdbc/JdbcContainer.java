package dev.inward.matrix.crud.jdbc;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Bus;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Closeable;

public class JdbcContainer<N,O extends Operational<N,W,?>,W extends Datum<N,O,?>> extends Container<N,O,W> {

    public JdbcContainer(O options, Bus<N,O, W,?,?,?,?,?,?,?> bus) {
        super(options, bus);
    }
    @SuppressWarnings("unchecked")

    @Override
    protected boolean reuseInterest(Datum artifact, boolean currently) {
        return currently;
    }

    public SQLException handleSQLException(SQLException sqlException, Datum delegatedInstance) {
        logger.debug(sqlException.getMessage());
        SqlExceptionWrapper sqlExceptionWrapped = this.advice.wrapAdviseSqlException(sqlException);
        this.reviewException(delegatedInstance, sqlExceptionWrapped.getRecommendation());
        return sqlExceptionWrapped;
    }

    public SQLClientInfoException handleSQLClientInfoException(SQLClientInfoException sqlClientInfoException, Datum delegatedInstance) {
        logger.debug(sqlClientInfoException.getMessage());
        SqlClientInfoExceptionWrapper sqlClientInfoExceptionWrapper = this.advice.adviseSQLClientInfoException(sqlClientInfoException);
        this.reviewException(delegatedInstance, sqlClientInfoExceptionWrapper.getRecommendation());
        return sqlClientInfoExceptionWrapper;
    }

 public static void DoDelegateClose(Object delegate) {
        if (delegate == null) return;
        try {
        if (delegate instanceof Closeable) {
        ((Closeable) delegate).close();
        } else if (delegate instanceof Clob) {
        ((Clob) delegate).free();
        } else if (delegate instanceof Blob) {
        ((Blob) delegate).free();
        } else if (delegate instanceof Array) {
        ((Array) delegate).free();
        }
        } catch (Exception e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception trying to clean up Reference was ignored: ");
        Container.PrintCause(e, stringBuilder);
        logger.error(stringBuilder.toString());
        }
    }



    @Override
    public int compareTo(JdbcContainer that) {
        if (this.containerId.equals(that.containerId)) {
            return 0;
        } else {
            return (this.createInstant.compareTo(that.createInstant) == 0) ?
                    this.containerId.compareTo(that.containerId) :
                    this.createInstant.compareTo(that.createInstant);
        }
    }

    @Override
    public void reviewException(Datum connectionArtifact, Recommendation recommendation) {
        if (recommendation.shouldClose() && connectionArtifact != null) {
            logger.debug("Close delegate");
            this.closeDelegate(connectionArtifact);
        }
        if (recommendation.isFailoverToNextConnectionSupplier()) {
            logger.info("Failover");
            this.pool.doFailover(recommendation);
        }
    }
}
