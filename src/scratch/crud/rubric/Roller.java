/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.rubric;

import dev.inward.matrix.concept.matter.Indicia;

public class Roller extends Throwable {

    protected final Indicia indicia;

    public Roller(String locus, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(e);
        this.indicia = new Indicia(locus, focus, severity);
    }

    public Indicia getSubject() {
        return indicia;
    }
}
