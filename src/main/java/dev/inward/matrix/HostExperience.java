/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.dns.serverRecord.ServerRecord;
import dev.inward.matrix.file.addressed.log.Occurrence;

import java.net.InetAddress;
import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class HostExperience {

    protected final InetAddress inetAddress;
    protected Instant lastUpdate = Instant.now();

    public HostExperience(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }
    public void resetLastUpdate() {
        this.lastUpdate = Instant.now();
    }

    public static class Server extends HostExperience {

        protected LocalSystemNetworking.NetworkMapping networkMapping;
        public Server(LocalSystemNetworking.NetworkMapping networkMapping) {
            super(networkMapping.getInterfaceAddress().getAddress());
            this.networkMapping = networkMapping;
        }

    }
    public static class Client extends HostExperience {

        protected final Queue<Occurrence> occurrences = new ConcurrentLinkedQueue<>();
        protected int occurrencesToSave;
        public Client(InetAddress inetAddress, int occurrencesToSave) {
            super(inetAddress);
            this.occurrencesToSave = occurrencesToSave;
        }
        public void addOccurrence(Occurrence occurrence) {
            this.occurrences.add(occurrence);
            if (this.occurrences.size() > occurrencesToSave) {
                this.occurrences.poll();
            }
        }

    }

}
