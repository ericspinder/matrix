package dev.inward.matrix.info;

import dev.inward.matrix.Index;
import dev.inward.matrix.Specification;
import dev.inward.matrix.Standard;

import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.GroupPrincipal;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class House extends Dogma<House.Identity, House, House.Representative, House.HouseAttributes> implements GroupPrincipal {

    protected final Map<Persona, AclEntry[]> personaRightsMap = new ConcurrentHashMap<>();

    public House(Identity identity, Map<Persona, AclEntry[]> personaRightsMap) {
        super(identity);
        if (personaRightsMap != null) {
            this.personaRightsMap.putAll(personaRightsMap);
        }
    }

    public static class Identity extends Dogma.Identity<Identity,House, Representative, HouseAttributes> {

        public Identity(String s, Index<Path_ofInfo> index) {
            super(s, index);
        }
    }

    public static class Representative extends Dogma.Representative<Identity,House, Representative, HouseAttributes> {

        public Representative(dev.inward.matrix.info.House addressed, Resource resource) {
            super(addressed, resource);
        }
    }

    public static class HouseAttributes extends Dogma.DogmaAttributes<Identity, House, Representative,HouseAttributes> {

        public HouseAttributes(Properties properties, long size) {
            super(properties, size);
        }
    }
    public static class Resource extends Dogma.Resource<Identity,House, Representative,HouseAttributes> {

        public Resource(Standard standard, Function<Representative, Representative> graveDigger, Specification specification) {
            super(standard, graveDigger, specification);
        }
    }
}
