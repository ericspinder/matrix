package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Properties;

public class Notion<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,PR>,A extends Addressed<PATH,ID,I,A,R,PR>,R extends Representitive<PATH,ID,I,A,R,PR>,PR extends Representitive<PATH,?,?,?,PR,?>> extends Operation<PATH,ID,I,A,R,PR> {

    public Notion(URL url,Properties properties) {
        super(url,properties);
    }

    @Override
    public <F extends FileAttributes> F newFileAttribute(Properties properties) {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

    }

    public static class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,PR>,A extends Addressed<PATH,ID,I,A,R,PR>,R extends Representitive<PATH,ID,I,A,R,PR>,PR extends Representitive<PATH,?,?,?,PR,?>> extends dev.inward.matrix.director.library.catalog.Gathering<PATH,ID,I,A,PR,R,Notion<PATH,ID,I,A,R,PR>> {

        public Gathering(Addressed.Resource<PATH,ID,I,A,R,PR> resource, List<Notion<PATH,ID,I,A,R,PR>> containers) {
            super(resource, containers);
        }
    }

}
