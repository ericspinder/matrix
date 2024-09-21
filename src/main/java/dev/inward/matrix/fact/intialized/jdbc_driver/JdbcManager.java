package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.Standard;
import dev.inward.matrix.fact.intialized.Manager;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Corpus;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Mechanical;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Sandbox;
import dev.inward.matrix.fact.authoritative.notion.house.Assembly;
import dev.inward.matrix.fact.authoritative.notion.house.Steward;
import dev.inward.matrix.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public class JdbcManager extends Manager<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated, Assembly, Corpus, Mechanical, Sandbox, Steward> {

    public JdbcManager(Steward mortal, Storage storage, Map<Standard<?, JdbcConnection, Identity.Ego, Context.Demarc>, Resource<JdbcManager, ?, ?, ?, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
