package dev.inward.matrix.advisor.advice;

import dev.inward.crud.IoExceptionWrapper;
import dev.inward.crud.SqlClientInfoExceptionWrapper;
import dev.inward.matrix.Recommendation;
import dev.inward.matrix.SqlExceptionWrapper;
import dev.inward.matrix.advisor.Advisor;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Gathering;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.aggregation.Participants;

import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Advice<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X>,F extends Fact<F,I,X>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>,L extends Gathering.Ledger<Y,D,F,O,I,X,B,P,E>,A extends Advisor<Y,D,F,O,I,X,B,P,A>> {

    public abstract Participants<Y,D,F,O,I,X,B,P,E,L> supply();






    protected abstract Recommendation parseSqlState(String sqlState);
    protected abstract Recommendation addSocketTimeout();
    protected abstract Recommendation examineMessage(String message);

    public Advice(A advisor) {

    }

    protected Recommendation examine(Throwable throwable, List<Recommendation> previousRecommendations) {

        if (throwable instanceof SQLException) {
            previousRecommendations.add(parseSqlState(((SQLException) throwable).getSQLState()));
        }
        if (throwable instanceof java.net.SocketTimeoutException) {
            previousRecommendations.add(addSocketTimeout());
        }
        previousRecommendations.add(examineMessage(throwable.getMessage()));
        if (throwable.getCause() != null) {
            return this.examine(throwable.getCause(), previousRecommendations);
        }
        return findMostSerious(previousRecommendations);
    }
    protected Recommendation findMostSerious(List<Recommendation> previousRecommendations) {
        if (Recommendation.Authentication_Failover.isInCollection(previousRecommendations)) {
            return Recommendation.Authentication_Failover;
        }
        if (Recommendation.Database_Failover.isInCollection(previousRecommendations)) {
            return Recommendation.Database_Failover;
        }
        for (Recommendation recommendation :previousRecommendations) {
            if (recommendation.isFailoverToNextConnectionSupplier()) {
                return recommendation;
            }
        }
        return Recommendation.Close_Closable;
    }

    public SqlExceptionWrapper wrapAdviseSqlException(SQLException sqlException) {
        StringBuilder s = new StringBuilder();
        s.append("NotionDs wrapped SQLException, recommendation=");
        try {
            Recommendation recommendation = this.examine(sqlException, new ArrayList<>());
            s.append(recommendation);
            return new SqlExceptionWrapper(s.toString(), sqlException, recommendation);
        }
        finally {
//            if (logger.isDebugEnabled()) {
//                s.append('\n').append(sqlException);
//            }
//            logger.info(s.toString());
        }
    }
    public SqlClientInfoExceptionWrapper adviseSQLClientInfoException(SQLClientInfoException sqlClientInfoException) {
        StringBuilder s = new StringBuilder();
        s.append("NotionDs wrapped SQLClientInfoException, recommendation=");
        try {
            Recommendation recommendation = this.examine(sqlClientInfoException, new ArrayList<>());
            s.append(recommendation);
            return new SqlClientInfoExceptionWrapper(s.toString(), recommendation, sqlClientInfoException);
        }
        finally {
//            if (logger.isDebugEnabled()) {
//                s.append('\n').append(sqlClientInfoException);
//            }
//            logger.info(s.toString());
        }
    }
    public IoExceptionWrapper adviseIoException(IOException ioException) {
        StringBuilder s = new StringBuilder();
        s.append("NotionDs wrapped IOException, recommendation=");
        try {
            Recommendation recommendation = this.examine(ioException, new ArrayList<>());
            s.append(recommendation);
            return new IoExceptionWrapper(s.toString(), recommendation, ioException);
        }
        finally {
//            if (logger.isDebugEnabled()) {
//                s.append('\n').append(ioException);
//            }
//            logger.info(s.toString());
        }
    }
//    public ExceptionWrapper adviseException(Exception exception) {
//        StringBuilder s = new StringBuilder();
//        s.append("NotionDs wrapped Exception, recommendation=");
//        try {
//            Recommendation recommendation = this.examine(exception, new ArrayList<>());
//            s.append(recommendation);
//            return new ExceptionWrapper(s.toString(), recommendation, exception);
//        }
//        finally {
////            if (logger.isDebugEnabled()) {
////                s.append('\n').append(exception);
////            }
////            logger.info(s.toString());
//        }
//    }

}
