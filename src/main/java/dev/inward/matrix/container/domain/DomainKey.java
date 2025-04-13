/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DomainKey extends MatrixKey<DomainKey,Domain,DomainView,DomainModel,DomainReference,DomainGestalt> {

    private final Terrene terrene;
    private final String domainName;

    protected DomainKey(URI uri, Terrene terrene, String domainName) {
        super(uri);
        this.terrene = terrene;
        this.domainName = domainName;
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public String getDomainName() {
        return domainName;
    }

    public static class Builder extends MatrixKey.Builder<DomainKey,Domain,DomainView,DomainModel,DomainReference,DomainGestalt> {

        protected final Map<String,DomainKey> ALL_KNOWN_DOMAINS = new ConcurrentHashMap<>();

        protected Terrene terrene;
        protected String domainName;

        public Builder setTerrene(Terrene terrene) {
            this.terrene = terrene;
            return this;
        }

        public Builder setDomainName(String domainName) {
            this.domainName = domainName;
            return this;
        }

        @Override
        protected URI makeUri() throws URISyntaxException {
            return new URI(terrene + ".allSchemes://" + domainName);
        }

        @Override
        protected DomainKey newMatrixKey() {
            String uriString = this.uri.toString();
            if (!ALL_KNOWN_DOMAINS.containsKey(uriString)) {
                this.cacheNewDomainKey(uriString);
            }
            return ALL_KNOWN_DOMAINS.get(uriString);
        }
        private synchronized void cacheNewDomainKey(String uriString) {
            if (!ALL_KNOWN_DOMAINS.containsKey(uriString)) {
                ALL_KNOWN_DOMAINS.put(uriString, new DomainKey(this.uri,this.terrene,this.domainName));
            }
        }
    }
}
