/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.local;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.ControlModel;

public class LocalModel extends ControlModel<Local,LocalView,LocalModel> {

    public LocalModel(Aspect[] labeledAspects) {
        super(Local.class, labeledAspects);
    }


}
