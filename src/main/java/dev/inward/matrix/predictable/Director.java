/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.*;
import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.DriverFactory;
import dev.inward.matrix.route.Road;

import java.lang.ref.PhantomReference;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Director {

    protected final Map<Deque<?>, PhantomReference<Predictable>> predictableDequeMap = new HashMap<>();

    protected final Map<String,Road> roadByMatrixKeyPath = new WeakHashMap<>();

    public Director() {

    }


}
