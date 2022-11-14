module dev.inward.matrix {
    requires transitive java.instrument;
    exports dev.inward.matrix to java.instrument;
    requires transitive org.objectweb.asm;
    requires transitive com.google.common;
    requires jsr305;
    exports dev.inward.matrix.fact.datum;
    exports dev.inward.matrix.fact.matter;
    exports dev.inward.matrix.engine;
    exports crud.rubric;
    exports dev.inward.matrix.fact;
    exports dev.inward.matrix.fact.notion.house.ziggurat to java.instrument;
}