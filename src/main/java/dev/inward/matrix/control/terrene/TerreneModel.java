/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.terrene;

import dev.inward.matrix.control.ControlModel;

import java.security.Permission;
import java.util.Enumeration;

public class TerreneModel extends ControlModel<Terrene,TerreneView,TerreneModel> {
    @Override
    public void add(Permission permission) {

    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return null;
    }
}
