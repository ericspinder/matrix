/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.network;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.catalog.CatalogModel;

public abstract class NetworkClientModel<NC extends NetworkClient<NC,NV,NM>,NV extends NetworkClientView<NC,NV,NM>,NM extends NetworkClientModel<NC,NV,NM>> extends CatalogModel<NC,NV,NM> {
    public NetworkClientModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
