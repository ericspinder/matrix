module dev.inward.matrix {
    requires transitive java.instrument;
    requires transitive org.objectweb.asm;
    requires transitive com.google.common;
    requires jsr305;
    requires transitive jdk.security.auth;
    exports dev.inward.matrix.fact.datum;
    exports dev.inward.matrix.fact.matter;
    exports dev.inward.matrix.engine;
    exports crud.rubric;
    exports dev.inward.matrix.fact;
    exports dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat to java.instrument;
    exports dev.inward.matrix.route;
    exports dev.inward.matrix.fact.tracked;
    exports dev.inward.matrix.fact.authoritative;
}