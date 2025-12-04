/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog;

import dev.inward.matrix.View;

import java.nio.file.attribute.FileStoreAttributeView;

public abstract class CatalogView<MC extends Catalog<MC,MV,MM>,MV extends CatalogView<MC,MV,MM>,MM extends CatalogModel<MC,MV,MM>> extends View<MC,MV,MM> implements FileStoreAttributeView {

    public CatalogView(String name, MC memory) {
        super(name, memory);
    }
}
