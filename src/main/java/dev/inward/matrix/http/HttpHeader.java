package dev.inward.matrix.http;

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
