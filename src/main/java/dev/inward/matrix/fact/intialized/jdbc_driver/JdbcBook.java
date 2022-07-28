package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.intialized.Book;

public class JdbcBook extends Book<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.JVM, JdbcBook, JdbcDelegated> {
    public JdbcBook(JdbcFunctionary operational) {
        super(operational);
    }
}
