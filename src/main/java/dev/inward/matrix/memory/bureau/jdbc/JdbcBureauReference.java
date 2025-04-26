/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.jdbc;

import dev.inward.matrix.memory.bureau.BureauReference;

public class JdbcBureauReference<BD extends JdbcBureau<BD,BV,BM,BR,BB>,BV extends JdbcBureauView<BD,BV,BM,BR,BB>,BM extends JdbcBureauModel<BD,BV,BM,BR,BB>,BR extends JdbcBureauReference<BD,BV,BM,BR,BB>,BB extends JdbcBureauLibrarian<BD,BV,BM,BR,BB>> extends BureauReference<BD,BV,BM,BR,BB> {

    public JdbcBureauReference(BD referent, BB librarian) {
        super(referent, librarian);
    }
}
