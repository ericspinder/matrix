package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Indicia;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class Domain implements Comparable<Domain> {

    protected final String domain;
    protected transient URL url = null;

    public Domain(@Nonnull String domain) {
        this.domain = domain;
    }

    public URL getUrl() {
        if (url == null) {
            try {
                this.url = new URL(domain);
            }
            catch (MalformedURLException malformedURLException) {
                throw new MatrixException(MatrixException.Type.Domain_not_initialized_malformed_URL,"unable to create domain", Indicia.Focus.Assembly, Indicia.Severity.Exceptional,malformedURLException);
            }
        }
        return url;
    }

    @Override
    public int compareTo(Domain that) {
        return this.url.toExternalForm().compareTo(that.url.toExternalForm());
    }

}
