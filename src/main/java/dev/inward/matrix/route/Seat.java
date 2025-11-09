/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import dev.inward.matrix.file.addressed.log.Log;
import dev.inward.matrix.predictable.Director;

import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

public abstract class Seat<S extends Seat<S>> implements Runnable {

    protected final UUID uuid = UUID.randomUUID();
    protected final ConcurrentLinkedDeque<Log> competedLogs = new ConcurrentLinkedDeque<>();
    protected final WeakReference<Director> directorWeakReference;


}
