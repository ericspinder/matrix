/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.Experience;
import dev.inward.matrix.Matrix;
import dev.inward.matrix.concept.fact.directory.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.terrene.Terrene;
import dev.inward.matrix.control.authority.*;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.*;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;

public abstract class Scheme<S extends Scheme<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,L extends Library<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,A extends Authority<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DF extends Directory<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,PATH extends Comparable<PATH>> extends FileSystemProvider implements Control<S,SV,SM>, Comparable<S> {

    public enum Reserved {
        Semicolon(';'),
        Slash('/'),
        Query('?'),
        Colon(':'),
        At('@'),
        And('&'),
        Equal('='),
        Plus('+'),
        Dollar('$'),
        Comma(','),
        Bracket_Open('['),
        Bracket_Close(']'),
        ;
        final char reserved;
        Reserved(char reserved) {
            this.reserved = reserved;
        }

        public char getReserved() {
            return reserved;
        }
    }
    public enum Unwise {
        Parentheses_Open('{'),
        Parentheses_Close('}'),
        Pipe('|'),
        BackSlash('\\'),
        Hat('^'),
        Grave('`'),
        ;
        final char unwise;

        Unwise(char unwise) {
            this.unwise = unwise;
        }

        public char getUnwise() {
            return unwise;
        }
    }

    public static Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> FindScheme(Terrene terrene, ProtocolParser<?> protocolParser) {
        String scheme = Terrene.KnownWorlds.get(terrene) + "." + protocolParser.getProtocol().getLabel();
    }
    protected final Map<L, Experience.LibraryEx> libraries = new WeakHashMap<>();

    protected final Terrene terrene;
    protected final ProtocolParser<PATH> protocolParser;
    protected final String scheme;
    protected final UUID uuid = UUID.randomUUID();
    protected final SM model;

    protected Scheme(Terrene terrene, ProtocolParser<PATH> protocolParser) {
        this.terrene = terrene;
        this.protocolParser = protocolParser;
        this.scheme = terrene.toString() + '.' + protocolParser.getProtocol().getLabel();
        this.model = createSchemeModel();
    }
    protected abstract SM createSchemeModel();
    protected abstract L createNewLibrary(Domain domain,int port);
    public L findLibrary(URI uri) {
        String library_cache_key = uri.getHost() + ((uri.getPort() < 1) ? protocolParser.getProtocol().getDefaultPort():uri.getPort());
        if (libraries.containsKey(library_cache_key)) {
            return libraries.get(library_cache_key);
        }
        Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> scheme = Matrix.findSchemeByString(uri.getScheme());
        return this.buildLibrary(, uri.getPort(),library_cache_key);

    }
    @SuppressWarnings("unchecked")
    public synchronized L buildLibrary(Domain domain, int port, String library_cache_key) {

        if (libraries.containsKey(library_cache_key)) {
            return libraries.get(library_cache_key);
        }
        L library = this.createNewLibrary(domain,port);
        this.libraries.put(library_cache_key, library);
        return library;
    }

    @Override
    public final SM getModel() {
        return model;
    }

    protected long getExceptionalSeries() {
        return 0;
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public ProtocolParser<PATH> getProtocolParser() {
        return protocolParser;
    }

    @Override
    public String getScheme() {
        return scheme;
    }

    @Override
    public String toString() {
        return String.valueOf(terrene).toLowerCase() + '.' + scheme.toLowerCase();
    }

    @Override
    public int compareTo(@NotNull S o) {
        return 0;
    }


    @Override
    public FileSystem newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        return null;
    }

    @Override
    public FileSystem getFileSystem(URI uri) {
        return null;
    }

    @NotNull
    @Override
    public Path getPath(@NotNull URI uri) {
        return null;
    }

    @Override
    public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        return null;
    }

    @Override
    public DirectoryStream<Path> newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter) throws IOException {
        return null;
    }

    @Override
    public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {

    }

    @Override
    public void delete(Path path) throws IOException {

    }

    @Override
    public void copy(Path source, Path target, CopyOption... options) throws IOException {

    }

    @Override
    public void move(Path source, Path target, CopyOption... options) throws IOException {

    }

    @Override
    public boolean isSameFile(Path path, Path path2) throws IOException {
        return false;
    }

    @Override
    public boolean isHidden(Path path) throws IOException {
        return false;
    }

    @Override
    public FileStore getFileStore(Path path) throws IOException {
        return null;
    }

    @Override
    public void checkAccess(Path path, AccessMode... modes) throws IOException {

    }

    @Override
    public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options) {
        return null;
    }

    @Override
    public <FA extends BasicFileAttributes> FA readAttributes(Path path, Class<FA> type, LinkOption... options) throws IOException {
        return null;
    }

    @Override
    public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        return Map.of();
    }

    @Override
    public void setAttribute(Path path, String attribute, Object value, LinkOption... options) throws IOException {

    }
}
