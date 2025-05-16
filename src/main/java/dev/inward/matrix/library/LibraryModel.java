/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;

public abstract class LibraryModel<MC extends Library<MC,MV,MM>,MV extends LibraryView<MC,MV,MM>,MM extends LibraryModel<MC,MV,MM>> extends Model<MC> {
    public LibraryModel(Class<MC> memoryClass, Aspect[] labeledAspects) {
        super(memoryClass, labeledAspects);
    }
}
