/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.http;

import dev.inward.matrix.Protocol;
import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.terrene.Terrene;

public class HttpProtocolParser extends ProtocolParser<String> {

    public HttpProtocolParser() {
        super(Protocol.HTTP);
    }

    @Override
    public String parsePath(String rawPath) {
        return rawPath;
    }

    @Override
    public HttpScheme newScheme(Terrene terrene) {
        return new HttpScheme(terrene);
    }
}
