/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.network.nioClient;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.memory.bureau.network.NetworkClientModel;

public class NioClientModel extends NetworkClientModel<NioClient,NioClientView,NioClientModel,NioClientReference,NioClientLibrarian> {
    public NioClientModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
