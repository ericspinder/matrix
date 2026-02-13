/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.ControlModel;

public abstract class CatalogModel<CC extends Catalog<CC, CV, CM,TS>, CV extends CatalogView<CC, CV, CM,TS>, CM extends CatalogModel<CC, CV, CM,TS>,TS extends TargetSource> extends ControlModel<CC,CV,CM> {


    public CatalogModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
