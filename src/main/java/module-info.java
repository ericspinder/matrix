@SuppressWarnings({ "requires-automatic", "requires-transitive-automatic" })
module dev.inward.matrix {
    requires transitive java.instrument;
    requires transitive org.objectweb.asm;
    requires transitive com.google.common;
    requires jsr305;
    requires transitive jdk.security.auth;
    exports dev.inward.matrix.fact.datum;
    exports dev.inward.matrix.concept.matter;
    exports dev.inward.matrix.engine;
    exports dev.inward.matrix.fact;
    exports dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat to java.instrument;
    exports dev.inward.matrix.route;
    //exports dev.inward.source.fact.tracked;
    exports dev.inward.matrix.fact.authoritative;
    exports dev.inward.matrix.personality;
    exports dev.inward.matrix.resources;
    exports dev.inward.matrix.director.library.catalog;
    exports dev.inward.matrix.director.library;
    exports dev.inward.matrix.director;
    exports dev.inward.matrix;
}