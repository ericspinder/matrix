/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */



package dev.inward.matrix.route;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Driver extends Thread implements Comparable<Driver> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createInstant = Instant.now();
    protected Map<String, Cipher> initializedCiphers;


    public Driver(Dispatch group, Runnable target, String name,
                  long stackSize) {
        super(group,target,name,stackSize,false);
    }
    public synchronized Cipher getCipher(String cipherString) throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (initializedCiphers.containsKey(cipherString)) {
            return initializedCiphers.get(cipherString);
        }
        Cipher cipher = Cipher.getInstance(cipherString);
        this.initializedCiphers.put(cipherString,cipher);
        return cipher;
    }
    @SuppressWarnings("unchecked")
    public Dispatch getDispatch() {
        return (Dispatch) this.getThreadGroup();
    }
    public Set<String> listInitializedCyphers() {
        return this.initializedCiphers.keySet();
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public int compareTo(Driver that) {
        int isZero = this.getDispatch().compareTo(that.getDispatch());
        if (isZero == 0) {
            isZero = this.getName().compareTo(that.getName());
            if (isZero == 0) {
                return this.uuid.compareTo(that.uuid);
            }
        }
        return isZero;
    }
}
