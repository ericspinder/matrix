/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;

public class BureauModel<BK extends BureauKey<BK,BI,BV,BM,BR,BG>,BI extends Bureau<BK,BI,BV,BM,BR,BG>,BV extends BureauView<BK,BI,BV,BM,BR,BG>,BM extends BureauModel<BK,BI,BV,BM,BR,BG>,BR extends BureauReference<BK,BI,BV,BM,BR,BG>,BG extends BureauGestalt<BK,BI,BV,BM,BR,BG>> extends Model<BI> {
    public BureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
