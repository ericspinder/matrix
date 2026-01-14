/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.engine;

import dev.inward.matrix.Seat;
import dev.inward.matrix.concept.catalog.Catalog;
import dev.inward.matrix.concept.Concept;
import dev.inward.matrix.concept.fact.*;
import dev.inward.matrix.concept.item.datum.Datum;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.terrene.*;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class Engine {


    private Map<String, Terrene> KnownWorlds() {
        Map<String, Terrene> knownWorlds = new HashMap<>();
        knownWorlds.put("earth",new Earth());
        knownWorlds.put("luna", new Luna());
        knownWorlds.put("mars", new Mars());
        knownWorlds.put("helios", new Helios());
        knownWorlds.put("chaosnet", new Chaosnet());
        knownWorlds.put("hesiod", new Hesiod());
        return knownWorlds;
    }
    private final Map<String, Terrene> KnownWorlds = KnownWorlds();
    private final Map<String, Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> ALL_KNOWN_SCHEMES = new HashMap<>();
    private final Map<String, Reference<Domain>> seenDomains = new HashMap<>();
    private final Map<Library.LibraryKey, Reference<Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>>> seenLibrariesByDomainsSchemes = new HashMap<>();
    private final Map<String, Reference<Authority<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>>> seenAuthorities = new HashMap<>();

    private Engine() {

    }
    private Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getLibrary(URI uri) {
        Library.LibraryKey libraryKey = Library.getLibraryKey(uri);
        Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library = seenLibrariesByDomainsSchemes.get(libraryKey).get();
        if (library == null) {
            synchronized (seenLibrariesByDomainsSchemes) {
                library = seenLibrariesByDomainsSchemes.get(libraryKey).get();
                if (library == null) {
                    Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> scheme = findSchemeByString(uri.getScheme());
                    Domain domain = getDomain(scheme.getTerrene(), uri.getHost());
                    library = scheme.getProtocolParser().newLibrary()
                }

            }
        }
    }


    /**
     *  Note that the input string is inclusive of the 'terrene' value such as "mars.log"
     *  For values without a '.', earth will be assumed. , unless overrided by the "-DdefaultTerrene=mars" command line or other system property assignment.
     *
     * @param scheme_s
     * @return a Scheme object
     */
    public Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> findSchemeByString(String scheme_s) {
        String lowerCaseScheme = scheme_s.toLowerCase();
        String schemeCacheKey;
        Terrene terrene;
        if (lowerCaseScheme.lastIndexOf('.') == -1) {
            terrene = KnownWorlds.get(System.getenv().getOrDefault("defaultTerrene","earth"));
            schemeCacheKey =  terrene.dnsClassCode + "_" + lowerCaseScheme;
        }
        else {
            terrene = Terrene.Parse(lowerCaseScheme.substring(0,lowerCaseScheme.lastIndexOf('.')));
            schemeCacheKey = terrene.dnsClassCode + "_" + lowerCaseScheme.substring(lowerCaseScheme.lastIndexOf('.'));
        }
        Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> scheme = ALL_KNOWN_SCHEMES.get(schemeCacheKey);
        if (scheme == null) {
            synchronized (ALL_KNOWN_SCHEMES) {
                scheme = ALL_KNOWN_SCHEMES.get(schemeCacheKey);
                if (scheme == null) {
                    String protocol_s = lowerCaseScheme.substring(lowerCaseScheme.lastIndexOf('.'));
                    for (ProtocolParser<?> protocolParser: ProtocolParser.Instances.ALL) {
                        if (protocolParser.getProtocol().getLabel().equals(protocol_s)) {
                            scheme = protocolParser.newScheme(terrene);
                            ALL_KNOWN_SCHEMES.put(schemeCacheKey,scheme);
                            return scheme;
                        }
                    }
                    throw new RuntimeException("Protocol not found" + protocol_s);
                }
            }
        }
        return scheme;
    }
    private Domain getDomain(Terrene terrene, String domainName) {
        String domainKey = terrene.toString() + Scheme.Reserved.Colon + domainName;
        Reference<Domain> domainReference = this.seenDomains.get(domainKey);
        if (domainReference == null) {
            synchronized (this.seenDomains) {
                domainReference = this.seenDomains.get(domainKey);
                if (domainReference == null || domainReference.get() == null) {
                    Domain domain = new Domain(terrene, domainName);
                    this.seenDomains.put(domainKey,new WeakReference<>(domain));
                    return domain;
                }
            }
        }
        return domainReference.get();
    }

    public Operational getOperational() {
        return operational;
    }

    public R buildReference(DATUM datum) {
        Induction<> induction = (Induction<Y,DATUM,D,V,F,I,X,>) operational.specification().getStandards().get(datum.getClass());
        return induction.createEnvoy(datum,factory
        );
    }
    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,V>,V extends DatumReferenceWeak<DATUM,D,V>> V add(DATUM datum) {
        try {
            Concept<DATUM> steward = (Concept<DATUM>) this.producer.get(((D) datum).getClass());
            return this.defineClass()add(datum,this);
        }
        catch (ClassCastException cce) {

        }


//        for (Predictor<Y,?,F,O,I,X,B,P,?,?,?> predictor: predictorMap.keySet()) {
//            predictor.registerCriterion()
//        }
        return null;
    }
}
