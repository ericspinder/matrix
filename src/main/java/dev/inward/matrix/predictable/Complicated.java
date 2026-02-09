/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Model;
import dev.inward.matrix.View;
import dev.inward.matrix.concept.fact.Variant;

import java.nio.file.WatchEvent;

public record Complicated<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M>>(String name, Class<C> type, Variant variant) implements WatchEvent.Kind<C> {

}
