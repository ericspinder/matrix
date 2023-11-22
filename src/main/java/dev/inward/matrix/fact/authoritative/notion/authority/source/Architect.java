package dev.inward.matrix.fact.authoritative.notion.authority.source;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.authority.source.Source;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.fact.authoritative.notion.concept.Construct;
import dev.inward.matrix.route.Road;

import java.lang.ref.ReferenceQueue;
import java.net.URLStreamHandler;
import java.net.spi.URLStreamHandlerProvider;

public class Architect extends URLStreamHandlerProvider {

    public Architect() {
        super();
    }

    public <S extends Scheme<S,L>,L extends Library<S,L>,D extends Director<S,L,D,R>,R extends Road<S,L,D,R>> D  findURLStreamHandler(String protocol) {
        return null;
    }

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        return findURLStreamHandler(protocol);
    }
}
