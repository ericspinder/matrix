/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.jdbc;

import dev.inward.matrix.memory.bureau.BureauLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class JdbcBureauLibrarian<BD extends JdbcBureau<BD,BV,BM,BR,BB>,BV extends JdbcBureauView<BD,BV,BM,BR,BB>,BM extends JdbcBureauModel<BD,BV,BM,BR,BB>,BR extends JdbcBureauReference<BD,BV,BM,BR,BB>,BB extends JdbcBureauLibrarian<BD,BV,BM,BR,BB>> extends BureauLibrarian<BD,BV,BM,BR,BB> {
    public JdbcBureauLibrarian(Standard standard) {
        super(standard);
    }
}
