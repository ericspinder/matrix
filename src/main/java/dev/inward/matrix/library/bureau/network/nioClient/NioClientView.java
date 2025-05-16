/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.bureau.network.nioClient;

import dev.inward.matrix.library.bureau.network.NetworkClientView;


public class NioClientView extends NetworkClientView<NioClient,NioClientView,NioClientModel> {

    public NioClientView(NioClient bureau) {
        super("NIO Client View - ", bureau);
    }
}
