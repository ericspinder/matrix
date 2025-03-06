/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;


import dev.inward.matrix.Recommendation;

public interface NotionExceptionWrapper {

    String getMessage();
    Recommendation getRecommendation();
    Throwable getCause();
}
