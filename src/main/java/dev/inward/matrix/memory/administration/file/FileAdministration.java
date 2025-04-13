/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.administration.file;

import dev.inward.matrix.MatrixItem;
import dev.inward.matrix.memory.administration.Administration;

public abstract class FileAdministration<B extends FileAdministrationLibrarian<B,K,I,V,M,R, T>,K extends FileAdministrationKey<B,K,I,V,M,R, T>,I extends FileAdministration<B,K,I,V,M,R, T>,V extends FileAdministrationView<B,K,I,V,M,R, T>,M extends FileAdministrationModel<B,K,I,V,M,R, T>,R extends FileAdministrationReference<B,K,I,V,M,R, T>, T extends FileAdminstrationStewart<B,K,I,V,M,R, T>> extends Administration<B,K,I,V,M,R,T> {
}
