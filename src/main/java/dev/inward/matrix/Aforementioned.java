/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

public class Aforementioned {

    private static Matrix Instance;

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        try {
            if (Instance != null) {
                throw new RuntimeException("premain cannot be called twice");
            }
            Instance = new Matrix(new CommandLine(agentArgs), instrumentation);

        } catch (IOException e) {
            throw new InstantiationException("Cannot create instance of Matrix from premain method");
        }
    }
    public static Matrix getInstance() {
        Matrix Instance = Aforementioned.Instance;
        if(Instance == null) {
            throw new RuntimeException("Matrix instance is not initialized");
        }
        return Instance;
    }
}
