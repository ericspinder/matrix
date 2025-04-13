/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.network.nioClient;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.SocketAddress;
import dev.inward.matrix.bureau.network.NeworkGestalt;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class NioClientGestalt extends NeworkGestalt<NioClientKey,NioClient, NioClientView,NioClientModel,NioClientReference,NioClientGestalt> {
    public NioClientGestalt(Standard standard) {
        super(standard);
    }
}
