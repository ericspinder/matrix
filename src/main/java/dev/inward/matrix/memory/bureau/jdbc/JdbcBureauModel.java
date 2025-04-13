/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.jdbc;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.bureau.BureauModel;

public class JdbcBureauModel<K extends JdbcBureauKey<K,I,V,M,R,G>,I extends JdbcBureau<K,I,V,M,R,G>,V extends JdbcBureauView<K,I,V,M,R,G>,M extends JdbcBureauModel<K,I,V,M,R,G>,R extends JdbcBureauReference<K,I,V,M,R,G>,G extends JdbcBureauGestalt<K,I,V,M,R,G>> extends BureauModel<K,I,V,M,R,G> {
    public JdbcBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
