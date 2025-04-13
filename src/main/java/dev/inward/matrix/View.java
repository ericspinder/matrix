/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.util.Map;

public class View<DATUM,R extends Reference<DATUM,R,A,RESOURCE,M>,A extends View<DATUM,R,A,RESOURCE,M>,RESOURCE extends Resource<DATUM,R,A,RESOURCE,M>,M extends Model<DATUM,R,A,RESOURCE,M>> {



    public View(Map<String,Model.InstanceValue> properties) {
        this.properties = properties;
    }

    public Map<String, Model.InstanceValue> getProperties() {
        return properties;
    }
}
