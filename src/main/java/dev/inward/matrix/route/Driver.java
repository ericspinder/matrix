package dev.inward.matrix.route;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Driver<D extends Dispatch<D,R>,R extends Road<D,R>> extends Thread implements Comparable<Driver<D,R>> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createInstant = Instant.now();
    protected Map<String, Cipher> initializedCiphers;

    public Driver(D group, Runnable target, String name,
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
    public D getDispatch() {
        return (D) this.getThreadGroup();
    }
    public Set<String> listInitializedCyphers() {
        return this.initializedCiphers.keySet();
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public int compareTo(Driver<D, R> that) {
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
