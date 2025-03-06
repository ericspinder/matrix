/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.http;

public interface HttpHeader {
    String key();
    String description();
    Class<? super HttpHeader> klass();

    class DefaultHttpHeader implements HttpHeader {
        protected String key;
        protected String description;
        protected Class<? super HttpHeader> klass;
        DefaultHttpHeader(String key,String description,Class<? super HttpHeader> klass) {
            this.key = key;
            this.description = description;
            this.klass = klass;
        }
        public String key() {
            return this.key;
        }
        public String description() {
            return this.description;
        }
        public Class<? super HttpHeader> klass() {
            return this.klass;
        }
    }
}
