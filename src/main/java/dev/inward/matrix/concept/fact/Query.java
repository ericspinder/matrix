/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact;

import dev.inward.matrix.Aspect;

import java.net.URI;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Query {

    @SuppressWarnings("unchecked")
    public static Query of(URI uri) {
        // Extract the query and anchor
        String query = uri.getQuery();
        String fragment = uri.getFragment();
        String[] anchors;
        if (fragment != null) {
            anchors = fragment.split(" ");
        }
        else {
            anchors = new String[0];
        }
        // If there is a query, parse it
        if (query != null) {
            Map<String, String> params = new HashMap<>();
            Pattern pattern = Pattern.compile("([?&])([^=#]+)(=([^&#]*))?");
            Matcher matcher = pattern.matcher("?" + query);

            while (matcher.find()) {
                params.put(matcher.group(2), matcher.group(4) != null ? matcher.group(4) : "");
            }
            return new Query(params, anchors);
        }
        if (anchors.length == 0) {
            return null;
        }
        return new Query(Collections.EMPTY_MAP, anchors);

    }
    protected final Map<String,String> params;
    protected final String[] anchors;
    protected Map<Aspect,Object> aspects;

    private Query(Map<String,String> params, String[] anchors) {
        this.params = params;
        this.anchors = anchors;
    }

    public record Pair<VALUE>(Aspect aspect, VALUE value) implements Comparable<Pair<?>> {

        @Override
        public int compareTo(Pair<?> that) {
            return this.aspect.compareTo(that.aspect);
        }
    }

    public String[] getAnchors() {
        return anchors;
    }

}
