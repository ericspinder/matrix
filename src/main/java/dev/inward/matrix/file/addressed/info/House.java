/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.GroupPrincipal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class House extends Privilege<HouseKey,House,HouseView,HouseModel,HouseReference,HouseLibrarian> implements GroupPrincipal {

    protected final Map<Persona, AclEntry[]> personaRightsMap = new ConcurrentHashMap<>();

    public House(HouseKey houseKey, Map<Persona, AclEntry[]> personaRightsMap) {
        super(houseKey);
        if (personaRightsMap != null) {
            this.personaRightsMap.putAll(personaRightsMap);
        }
    }

}
