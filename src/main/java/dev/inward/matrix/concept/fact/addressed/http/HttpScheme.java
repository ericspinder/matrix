/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.http;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.terrene.Terrene;

public class HttpScheme extends Scheme<HttpScheme,HttpView,HttpModel<>> {

    public HttpScheme(Terrene terrene) {
        super(terrene, ProtocolParser.Instances.HTTP);
    }

    @Override
    protected Library<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createNewLibrary(Domain domain, int port) {
        return null;
    }
}
