/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.library.Library;

import java.lang.ref.WeakReference;

public class Ware<S extends Scheme<S,L>,L extends Library<S,L>,DATUM,W extends Ware<S,L,DATUM,W,A>,A extends View<S,L,DATUM,W,A>> extends WeakReference<DATUM> {


}
