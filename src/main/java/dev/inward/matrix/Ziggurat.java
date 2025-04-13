/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.predictable.Director;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;

public class Ziggurat {



    protected Ziggurat(ZigguratKey key, CommandLine commandLine, Instrumentation instrumentation) {
        this.key = key;
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;

    }

    @Override
    public ZigguratKey getKey() {
        return key;
    }

    public LocalSystemNetworking getLocalSystemNetworking() {
        return localSystemNetworking;
    }

    public CommandLine getCommandLine() {
        return commandLine;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }




}
