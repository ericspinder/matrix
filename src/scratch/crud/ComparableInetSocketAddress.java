/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ComparableInetSocketAddress extends InetSocketAddress implements Comparable<ComparableInetSocketAddress> {


    public ComparableInetSocketAddress(int port) {
        super(port);
    }

    public ComparableInetSocketAddress(InetAddress addr, int port) {
        super(addr, port);
    }

    public ComparableInetSocketAddress(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public int compareTo(ComparableInetSocketAddress o) {
        int isZero = this.getAddress().;
    }
}
