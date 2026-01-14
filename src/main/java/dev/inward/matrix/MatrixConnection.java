/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class MatrixConnection extends URLConnection {

    protected Map<String, List<String>> responseHeaderFields;

    /**
     * Constructs a URL connection to the specified URL. A connection to
     * the object referenced by the URL is not created.
     *
     * @param url the specified URL.
     */
    protected MatrixConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {

    }

    @Override
    public String getHeaderField(String name) {
        if (this.responseHeaderFields == null) {
            return null;
        }
        List<String> values = this.responseHeaderFields.get(name);
        if (values != null && !values.isEmpty()) {
            return values.getFirst();
        }
        return null;
    }

    @Override
    public String getHeaderFieldKey(int n) {
        if (this.responseHeaderFields == null) {
            return null;
        }
         return this.responseHeaderFields.keySet().toArray(new String[0])[n];
    }
    public void setResponseHeaderFields(Map<String, List<String>> responseHeaderFields) {
        this.responseHeaderFields = responseHeaderFields;
    }
    public Map<String, List<String>> getResponseHeaderFields() {
        return responseHeaderFields;
    }
    public void addResponseHeaderField(String key, String value) {
        if (this.responseHeaderFields == null) {
            this.responseHeaderFields = new LinkedHashMap<>();
        }
        this.responseHeaderFields.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

}
