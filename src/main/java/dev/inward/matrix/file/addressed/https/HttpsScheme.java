/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.https;

import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.file.addressed.http.HttpScheme;

public class HttpsScheme extends HttpScheme {

    public static final HttpsScheme EARTH_SCHEME_OF_HTTPS = new HttpsScheme(Terrene.Earth);
    public static final HttpsScheme LUNA_SCHEME_OF_HTTPS = new HttpsScheme(Terrene.Luna);
    public static final HttpsScheme MARS_SCHEME_OF_HTTPS = new HttpsScheme(Terrene.Mars);
    public static final HttpsScheme CHAOSNET_SCHEME_OF_HTTPS = new HttpsScheme(Terrene.Chaosnet);


    protected HttpsScheme(Terrene terrene) {
        super(terrene, MatrixURLStreamHandlerProvider.Protocol.HTTPS);
    }


}
