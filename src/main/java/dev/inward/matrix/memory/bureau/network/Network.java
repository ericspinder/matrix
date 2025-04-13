/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.network;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.bureau.Bureau;
import dev.inward.matrix.file.FileView;

import java.util.Map;

public abstract class Network<K extends NetworkKey<K,I,V,M,R,G>,I extends Network<K,I,V,M,R,G>,V extends NetworkView<K,I,V,M,R,G>,M extends NetworkModel<K,I,V,M,R,G>,R extends NetworkReference<K,I,V,M,R,G>,G extends NeworkGestalt<K,I,V,M,R,G>> extends Bureau<K,I,V,M,R,G> {

    protected final Hosts.Remote remoteHost;

    protected final Hosts.LocalHost localHost;
    public Network(K key, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, Hosts.Remote remoteHost, Hosts.LocalHost localHost) {
        super(key, attributes, supportedFileViews);
        this.remoteHost = remoteHost;
        this.localHost = localHost;
    }
}
