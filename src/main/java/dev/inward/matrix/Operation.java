package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;

public abstract class Operation<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,PR>,A extends Addressed<PATH,ID,I,A,R,PR>,R extends Representitive<PATH,ID,I,A,R,PR>,PR extends Representitive<PATH,?,?,?,PR,?>> implements BasicFileAttributeView {

    protected final URL url;
    protected final FileAttributes fileAttributes;

    public Operation(URL url, Properties properties) {
        this.url = url;
        this.fileAttributes = newFileAttribute(new Properties(properties));
    }

    public URL getUrl() {
        return url;
    }

    public FileAttributes getFileAttribute() {
        return this.fileAttributes;
    }
    public abstract <F extends FileAttributes> F newFileAttribute(Properties properties);

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return this.fileAttributes;
    }
}
