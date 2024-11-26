package dev.inward.matrix.memory;

import dev.inward.matrix.Pathway;
import dev.inward.matrix.Range;
import dev.inward.matrix.Standard;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.Concept;
import dev.inward.matrix.fact.Factory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JDBCMemory<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>> extends Memory<PATH,P>{
    public JDBCMemory(@Nonnull String name, @Nullable Range<PATH> range, Standard[] standards) {
        super(name,range,standards);
    }

    @Override
    public Map<Class<? extends Concept<PATH,P,?,?,?>>, Factory<PATH,P,?,?,?>> initSpaces(Standard[] standards) {
        Map<Class<? extends Concept<PATH,P,?,?,?>>, Factory<PATH,P,?,?,?>> conceptFactoryMap = new ConcurrentHashMap<>();
        for (Standard standard: standards) {
            String className = standard.getClassName();
            Variant<PATH,P,?,?,?> variant = standard.getVariant();
        }
        return null;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public long getTotalSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUsableSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUnallocatedSpace() throws IOException {
        return 0;
    }
}
