package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.corpus.*;
import dev.inward.matrix.fact.intialized.Manager;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class JdbcManager extends Manager<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.JVM, JdbcBook, JdbcDelegated, Assembly, Corpus, Mechanical, Sandbox, Prophet> {

    public JdbcManager(Prophet mortal, Resources resources, Map<Standard<?, JdbcConnection, Identity.Ego, Context.JVM>, Resource<JdbcManager, ?, ?, ?, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.JVM, JdbcBook, JdbcDelegated>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
