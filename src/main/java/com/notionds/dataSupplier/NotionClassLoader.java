package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;

import java.io.Serializable;

public class NotionClassLoader<DELEGATE extends Comparable<DELEGATE> & Serializable,O extends Options<DELEGATE,U,C,B,?,?,?,?,?>,U extends Datum<DELEGATE,O, C, B>,C extends Container<DELEGATE,O,U,B>,B extends Bus<DELEGATE,O, U, C,?,?,?,?,?>> extends ClassLoader {





}
