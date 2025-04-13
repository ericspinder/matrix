/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.network;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.SocketAddress;
import dev.inward.matrix.bureau.BureauKey;

import java.net.URI;

public class NetworkKey<K extends NetworkKey<K,I,V,M,R,G>,I extends Network<K,I,V,M,R,G>,V extends NetworkView<K,I,V,M,R,G>,M extends NetworkModel<K,I,V,M,R,G>,R extends NetworkReference<K,I,V,M,R,G>,G extends NeworkGestalt<K,I,V,M,R,G>> extends BureauKey<K,I,V,M,R,G> {
    protected NetworkKey(URI uri) {
        super(uri);
    }
}
