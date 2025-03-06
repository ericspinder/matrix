/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;

import dev.inward.matrix.Addressable;
import dev.inward.matrix.log.Request;
import dev.inward.matrix.log.Response;

public class DeleteResponse<R extends Addressable<R>, Q extends Request<?,?>> extends Response<R, Q> {

    @Override
    public int compareTo(R o) {
        return 0;
    }
}
