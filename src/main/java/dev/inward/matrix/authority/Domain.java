package dev.inward.matrix.authority;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.matter.Indicia;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class Domain implements Comparable<Domain> {

    protected transient final URL url;

    public Domain(@Nonnull String domain) {
        try {
            this.url = new URL(domain);
        }
        catch (MalformedURLException malformedURLException) {
            throw new MatrixException(MatrixException.Type.Domain_not_initialized_malformed_URL,"unable to create domain", Indicia.Focus.Assembly, Indicia.Severity.Exceptional,malformedURLException);
        }
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public int compareTo(Domain that) {
        return this.url.toExternalForm().compareTo(that.url.toExternalForm());
    }

}
