/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.fact.addressed.http.HttpProtocolParser;
import dev.inward.matrix.concept.fact.addressed.https.Https;
import dev.inward.matrix.concept.fact.addressed.ldap.LdapProtocolParser;
import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.terrene.Terrene;

import java.lang.reflect.InvocationTargetException;
import java.net.spi.URLStreamHandlerProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatrixURLStreamHandlerProvider extends URLStreamHandlerProvider {

    private static MatrixURLStreamHandlerProvider Instance;

    public static MatrixURLStreamHandlerProvider getInstance() {
        return Instance;
    }

    public MatrixURLStreamHandlerProvider() {
        Instance = this;
    }

    @Override
    public Ziggurat createURLStreamHandler(String scheme) {
        return Ziggurat.getInstance();
    }

}
