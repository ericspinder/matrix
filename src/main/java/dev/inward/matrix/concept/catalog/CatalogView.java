/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog;

import dev.inward.matrix.control.ControlView;

import java.nio.file.attribute.FileStoreAttributeView;

public abstract class CatalogView<CC extends Catalog<CC, CV, CM,TS>, CV extends CatalogView<CC, CV, CM,TS>, CM extends CatalogModel<CC, CV, CM,TS>,TS extends TargetSource> extends ControlView<CC,CV,CM> implements FileStoreAttributeView {

    public CatalogView(String name, CC catalog) {
        super(name, catalog);
    }
}
