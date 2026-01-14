/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.https;

import dev.inward.matrix.Protocol;
import dev.inward.matrix.concept.fact.addressed.http.HttpsScheme;
import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.terrene.Terrene;

public class Https extends ProtocolParser<String> {

    public Https() {
        super(Protocol.HTTPS);
    }

    @Override
    public String parsePath(String rawPath) {
        return rawPath;
    }

    @Override
    public HttpsScheme newScheme(Terrene terrene) {
        return new HttpsScheme(terrene);
    }
}
