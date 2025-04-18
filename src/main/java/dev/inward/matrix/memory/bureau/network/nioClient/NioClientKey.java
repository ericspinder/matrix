/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.network.nioClient;

import dev.inward.matrix.memory.bureau.network.NetworkKey;

import java.net.URI;

public class NioClientKey extends NetworkKey<NioClientKey,NioClient, NioClientView,NioClientModel,NioClientReference, NioClientLibrarian> {
    protected NioClientKey(URI uri) {
        super(uri);
    }
}
