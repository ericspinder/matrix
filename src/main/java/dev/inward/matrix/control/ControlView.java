/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control;

import dev.inward.matrix.View;

public class ControlView<CO extends Control<CO,CV,CM>,CV extends ControlView<CO,CV,CM>,CM extends ControlModel<CO,CV,CM>> extends View<CO,CV,CM> {

    public ControlView(String name, CO control) {
        super(name, control);
    }

    @Override
    public CM getModel() {
        return null;
    }


}
