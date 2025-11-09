/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.network;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.control.bureau.Bureau;
import dev.inward.matrix.file.FileView;

import java.util.Map;

public abstract class NetworkClient<BC extends NetworkClient<BC,BV,BM>,BV extends NetworkClientView<BC,BV,BM>,BM extends NetworkClientModel<BC,BV,BM>> extends Bureau<BC,BV,BM> {

    protected final Hosts.Remote remoteHost;

    protected final Hosts.LocalHost localHost;

    public NetworkClient(String name, boolean readOnly, BM networkClientModel, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, Hosts.Remote remoteHost, Hosts.LocalHost localHost) {
        super(name, readOnly, networkClientModel, attributes, supportedFileViews);
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
