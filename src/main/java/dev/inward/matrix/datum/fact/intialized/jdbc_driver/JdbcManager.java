package dev.inward.matrix.datum.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.datum.fact.intialized.Manager;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class JdbcManager extends Manager<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.JVM, JdbcBook, JdbcDelegated, Assembly, Corpus, Mechanical, Sandbox, Prophet> {

    public JdbcManager(Prophet mortal, Resources resources, Map<Standard<?, JdbcConnection, Identity.Ego, Context.JVM>, Resource<JdbcManager, ?, ?, ?, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.JVM, JdbcBook, JdbcDelegated>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
