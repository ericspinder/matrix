package dev.inward.matrix.datum.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.datum.fact.intialized.Manager;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class JdbcManager extends Manager<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Ethereal, JdbcBook, JdbcDelegated, Assembly, Corpus, Mechanical, Sandbox, Prophet> {

    public JdbcManager(Prophet mortal, Resources resources, Map<Standard<?, JdbcConnection, Identity.Ego, Context.Ethereal>, Resource<JdbcManager, ?, ?, ?, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Ethereal, JdbcBook, JdbcDelegated>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
