@SuppressWarnings({ "requires-automatic"})
module dev.inward.matrix {
    requires transitive java.instrument;
    requires transitive java.sql;
    requires transitive org.objectweb.asm;
    requires jsr305;
    requires transitive jdk.security.auth;
    exports dev.inward.matrix.engine;
    exports dev.inward.matrix.fact;
    exports dev.inward.matrix.route;
    exports dev.inward.matrix.personality;
    exports dev.inward.matrix.ticket;
    exports dev.inward.matrix to java.instrument;
    exports dev.inward.matrix.memory;
    exports  dev.inward.matrix.dns.resourceRecord;
    exports dev.inward.matrix.code;
    exports dev.inward.matrix.dns;
    exports dev.inward.matrix.https;
    exports dev.inward.matrix.log;
    exports dev.inward.crud;
    exports dev.inward.matrix.info;
    exports dev.inward.matrix.predictable;
}