/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.network;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.memory.bureau.Bureau;
import dev.inward.matrix.file.FileView;

import java.util.Map;

public abstract class NetworkClient<BD extends NetworkClient<BD,BV,BM,BR,BB>,BV extends NetworkClientView<BD,BV,BM,BR,BB>,BM extends NetworkClientModel<BD,BV,BM,BR,BB>,BR extends NetworkClientReference<BD,BV,BM,BR,BB>,BB extends NetworkClientLibrarian<BD,BV,BM,BR,BB>> extends Bureau<BD,BV,BM,BR,BB> {

    protected final Hosts.Remote remoteHost;

    protected final Hosts.LocalHost localHost;

    public NetworkClient(String name, boolean readOnly, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, Hosts.Remote remoteHost, Hosts.LocalHost localHost) {
        super(name, readOnly, attributes, supportedFileViews);
        this.localHost = localHost;
        this.remoteHost = remoteHost;
    }

    public Hosts.Remote getRemoteHost() {
        return remoteHost;
    }

    public Hosts.LocalHost getLocalHost() {
        return localHost;
    }
}
