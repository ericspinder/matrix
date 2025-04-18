@SuppressWarnings({ "requires-automatic"})
module dev.inward.matrix {
    requires transitive java.instrument;
    requires transitive java.sql;
    requires transitive org.objectweb.asm;
    requires transitive jdk.security.auth;
    exports dev.inward.matrix.engine;
    exports dev.inward.matrix.route;
    exports dev.inward.matrix.personality;
    exports dev.inward.matrix.ticket;
    exports dev.inward.matrix.memory.bureau;
    exports dev.inward.matrix.file.addressed.dns.nameServerRecord;
    exports dev.inward.matrix.file.addressed.depot;
    exports dev.inward.matrix.file.addressed.dns;
    exports dev.inward.matrix.file.addressed.https;
    exports dev.inward.matrix.file.addressed.log;
    exports dev.inward.matrix.file.addressed.info;
    exports dev.inward.matrix.predictable;
    exports dev.inward.matrix.operation to java.instrument;
    exports dev.inward.matrix;
    exports dev.inward.matrix.file.addressed.http;
    exports dev.inward.matrix.file.addressed.depot.indica;
    exports dev.inward.matrix.file.addressed;
    exports dev.inward.matrix.file;
    exports dev.inward.matrix.file.addressed.depot.standard;
    exports dev.inward.matrix.file.addressed.depot.source;
    exports dev.inward.matrix.file.addressed.depot.variant;
    exports dev.inward.matrix.file.addressed.depot.specification;
    exports dev.inward.matrix.file.addressed.dns.catalogRecord;
    exports dev.inward.matrix.file.addressed.dns.serverRecord;
    exports dev.inward.matrix.file.addressed.dns.serviceLocationRecord;
    exports dev.inward.matrix.file.addressed.dns.startOfAuthority;
    exports dev.inward.matrix.control;
    exports dev.inward.matrix.control.catalog;
    exports dev.inward.matrix.control.library;
    exports dev.inward.matrix.control.domain;
    exports dev.inward.matrix.memory.administration;
}