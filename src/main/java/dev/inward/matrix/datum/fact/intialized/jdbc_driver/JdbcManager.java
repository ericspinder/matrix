package dev.inward.matrix.datum.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.house.Assembly;
import dev.inward.matrix.datum.fact.notion.house.Steward;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.datum.fact.intialized.Manager;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public class JdbcManager extends Manager<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated, Assembly, Corpus, Mechanical, Sandbox, Steward> {

    public JdbcManager(Steward mortal, Storage storage, Map<Standard<?, JdbcConnection, Identity.Ego, Context.Demarc>, Resource<JdbcManager, ?, ?, ?, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
