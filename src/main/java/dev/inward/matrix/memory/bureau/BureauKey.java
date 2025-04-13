/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.MatrixKey;

import java.net.URI;

public class BureauKey<BK extends BureauKey<BK,BI,BV,BM,BR,BG>,BI extends Bureau<BK,BI,BV,BM,BR,BG>,BV extends BureauView<BK,BI,BV,BM,BR,BG>,BM extends BureauModel<BK,BI,BV,BM,BR,BG>,BR extends BureauReference<BK,BI,BV,BM,BR,BG>,BG extends BureauGestalt<BK,BI,BV,BM,BR,BG>> extends MatrixKey<BK,BI,BV,BM,BR,BG> {
    protected BureauKey(URI uri) {
        super(uri);
    }
}
