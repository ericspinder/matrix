package dev.inward.matrix.datum.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Book;

public class JdbcBook extends Book<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Ethereal, JdbcBook, JdbcDelegated> {
    public JdbcBook(JdbcFunctionary operational) {
        super(operational);
    }
}
