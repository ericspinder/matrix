/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix.item.datum;

import java.nio.file.WatchEvent;

public interface Datum<D extends Datum<D,V,M>,V extends DatumView<D,V,M>,M extends DatumModel<D,V,M>> extends WatchEvent.Modifier {

    Seat<D,V,M> getSeat();


}
