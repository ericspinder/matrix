/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau;

import dev.inward.matrix.Librarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class BureauLibrarian<BB extends BureauLibrarian<BB,BK,BI,BV,BM,BR,BT>,BK extends BureauKey<BB,BK,BI,BV,BM,BR,BT>,BI extends Bureau<BB,BK,BI,BV,BM,BR,BT>,BV extends BureauView<BB,BK,BI,BV,BM,BR,BT>,BM extends BureauModel<BB,BK,BI,BV,BM,BR,BT>,BR extends BureauReference<BB,BK,BI,BV,BM,BR,BT>,BT extends BureauLibrarian<BB,BK,BI,BV,BM,BR,BT>> extends Librarian<BB,BI,BV,BM,BR,BT> {
    public BureauLibrarian(Standard standard) {
        super(standard);
    }
}
