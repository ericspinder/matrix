/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Id;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;

public abstract class Indication<D extends Datum<D,O,C,I> ,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<D,I,?>,I8N extends Indication<D,O,C,I,I8N>> implements Comparable<I8N>, Serializable {


}
