package dev.inward.matrix.engine;

import dev.inward.matrix.phenomenon.io.InputOutput;

import java.util.Map;

public class Transport {

    protected final Zone zone;
    
    protected Map<InputOutput<?,?,?>,char[]> inputOutputMap;


    public Transport(Zone zone, Map<InputOutput<?,?,?>,char[]> inputOutputs) {
        this.zone = zone;
        this.inputOutputMap = inputOutputs;
    }

    public final Zone getZone() {
        return this.zone;
    }
    
    public InputOutput<?,?,?> getIO(Role role, char testCode) {
        for (Map.Entry<InputOutput<?,?,?>,char[]> inputOutput: inputOutputMap.entrySet()) {
            if (inputOutput.getKey().role().equals(role)) {
                for (char c : inputOutput.getValue()) {
                    if (c == testCode) return inputOutput.getKey();
                }
            }
        }
        return null;
    }

}
