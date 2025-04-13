/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.network.nioClient;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.SocketAddress;
import dev.inward.matrix.bureau.network.NetworkView;


public class NioClientView extends NetworkView<NioClientKey,NioClient, NioClientView,NioClientModel,NioClientReference,NioClientGestalt> {

    public NioClientView(NioClient bureau, NioClientModel bureauModel) {
        super("NioClientView", bureau, bureauModel);
    }
}
