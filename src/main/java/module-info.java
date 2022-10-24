module dev.inward.matrix {
    requires transitive org.objectweb.asm;
    requires transitive com.google.common;
    exports dev.inward.matrix.datum;
    exports dev.inward.matrix.matter;
    exports dev.inward.matrix.engine;
    exports crud.rubric;
    exports dev.inward.matrix.datum.fact;
}