/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.jdbc;

import dev.inward.matrix.bureau.BureauGestalt;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class JdbcBureauGestalt<K extends JdbcBureauKey<K,I,V,M,R,G>,I extends JdbcBureau<K,I,V,M,R,G>,V extends JdbcBureauView<K,I,V,M,R,G>,M extends JdbcBureauModel<K,I,V,M,R,G>,R extends JdbcBureauReference<K,I,V,M,R,G>,G extends JdbcBureauGestalt<K,I,V,M,R,G>> extends BureauGestalt<K,I,V,M,R,G> {
    public JdbcBureauGestalt(Standard standard) {
        super(standard);
    }
}
