package dev.inward.matrix;

import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.matter.Indicia;

import java.io.IOException;
import java.net.*;
import java.net.spi.URLStreamHandlerProvider;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Scheme<S extends Scheme<S,L>,L extends Library<S,L>> extends URLStreamHandler {

    protected final String scheme;
    protected final Map<Director<S,L,?,?>, L[]> libraries = new ConcurrentHashMap<>();

    protected Scheme(String scheme) {
        this.scheme = scheme;
    }

    public static class DNS extends Scheme<DNS,Library.DNS> {
        public final static DNS Instance = new DNS();
        private DNS() {
            super("dns");
        }
    }
    public static class HTML extends Scheme<HTML,Library.HTML> {
        public final static HTML Instance = new HTML();
        private HTML() {
            super("html");
        }
    }


    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return null;
    }
}
