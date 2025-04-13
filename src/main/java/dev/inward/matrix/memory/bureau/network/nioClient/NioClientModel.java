/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.network.nioClient;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Hosts;
import dev.inward.matrix.SocketAddress;
import dev.inward.matrix.bureau.network.NetworkModel;

public class NioClientModel extends NetworkModel<NioClientKey,NioClient, NioClientView,NioClientModel,NioClientReference,NioClientGestalt> {
    public NioClientModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
