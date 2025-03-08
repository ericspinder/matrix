/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.Attributes;
import dev.inward.matrix.Model;
import dev.inward.matrix.Reference;
import dev.inward.matrix.Resource;

import java.nio.file.attribute.AttributeView;

public class View<DATUM,R extends Reference<DATUM,R,A,RESOURCE,M>,A extends Attributes<DATUM,R,A,RESOURCE,M>,RESOURCE extends Resource<DATUM,R,A,RESOURCE,M>,M extends Model<DATUM,R,A,RESOURCE,M>> implements AttributeView {

    protected final String name;

    public View(String name, DATUM datum) {
        this.name = name;
    }
    @Override
    public String name() {
        return null;
    }
}
