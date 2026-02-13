/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.network;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.control.catalog.Mount;
import dev.inward.matrix.control.Control;

import java.util.Map;

public abstract class NetworkClient<NC extends NetworkClient<NC,NV,NM>,NV extends NetworkClientView<NC,NV,NM>,NM extends NetworkClientModel<NC,NV,NM>> extends Catalog<NC,NV,NM> {

    protected final Hosts.Remote remoteHost;

    protected final Hosts.LocalHost localHost;

    public NetworkClient(final Mount mount, String name, boolean readOnly, Control<?,?,?> control, Map<String,Object> attributes, Hosts.Remote remoteHost, Hosts.LocalHost localHost) {
        super(mount, name, readOnly, networkClientModel, attributes, supportedFileViews);
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
