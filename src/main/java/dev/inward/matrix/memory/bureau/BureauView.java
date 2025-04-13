/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.View;

import java.nio.file.attribute.FileStoreAttributeView;
import java.util.HashMap;
import java.util.Map;

public abstract class BureauView<BK extends BureauKey<BK,BI,BV,BM,BR,BG>,BI extends Bureau<BK,BI,BV,BM,BR,BG>,BV extends BureauView<BK,BI,BV,BM,BR,BG>,BM extends BureauModel<BK,BI,BV,BM,BR,BG>,BR extends BureauReference<BK,BI,BV,BM,BR,BG>,BG extends BureauGestalt<BK,BI,BV,BM,BR,BG>> extends View<BI,BM> implements FileStoreAttributeView {

    protected final Map<String,Object> attributes = new HashMap<>();
    public BureauView(String name, BI bureau, BM bureauModel) {
        super(name, bureau, bureauModel);
    }
}
