/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;

public abstract class ControlModel<CO extends Control<CO,CV,CM>,CV extends ControlView<CO,CV,CM>,CM extends ControlModel<CO,CV,CM>> extends Model<CO,CV,CM> {
    public ControlModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
