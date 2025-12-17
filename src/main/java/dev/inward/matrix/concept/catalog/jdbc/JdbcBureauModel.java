/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.jdbc;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.administration.BureauModel;

public abstract class JdbcBureauModel<BC extends JdbcCatalog<BC,BV,BM>,BV extends JdbcBureauView<BC,BV,BM>,BM extends JdbcBureauModel<BC,BV,BM>> extends BureauModel<BC,BV,BM> {
    public JdbcBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
