module dev.inward.matrix {
    requires transitive java.instrument;
    exports dev.inward.matrix to java.instrument;
    requires transitive org.objectweb.asm;
    requires transitive com.google.common;
    exports dev.inward.matrix.datum;
    exports dev.inward.matrix.datum.fact.matter;
    exports dev.inward.matrix.engine;
    exports crud.rubric;
    exports dev.inward.matrix.datum.fact;
    exports dev.inward.matrix.datum.fact.notion.house.ziggurat to java.instrument;
}