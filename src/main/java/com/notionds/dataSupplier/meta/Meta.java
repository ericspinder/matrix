package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public class Meta<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,?,?,?,?>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>> {


}
