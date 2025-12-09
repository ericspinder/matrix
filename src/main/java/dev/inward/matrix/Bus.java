/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public interface Bus<TARGET,V extends View<TARGET,V,M>, M extends Model<TARGET>,B extends Bus<TARGET,V,M,B>> extends Comparable<B> {

}
