/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.memory.bureau.Clerk;
import dev.inward.matrix.container.library.Library;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.nio.channels.AsynchronousChannel;

public class Scheduler<S extends Scheme<S,L>,L extends Library<S,L>,SCHEDULER extends Scheduler<S,L,SCHEDULER,CHANNEL,C>,CHANNEL extends AsynchronousChannel,C extends Clerk<S,L,CHANNEL,C>> {


    public Scheduler(Specification specification, tectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
