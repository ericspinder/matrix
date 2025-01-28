package dev.inward.matrix.info;

import dev.inward.matrix.Index;
import dev.inward.matrix.Specification;
import dev.inward.matrix.Standard;

import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.UserPrincipal;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Agent extends Dogma<Agent.Identity, Agent, Agent.Representative, Agent.AgentAttributes> implements UserPrincipal {

    protected final Map<House, AclEntry[]> houseRightsMap = new ConcurrentHashMap<>();

    public Agent(Identity identity, Map<House, AclEntry[]> houseRightsMap) {
        super(identity);
        if (houseRightsMap != null) {
            this.houseRightsMap.putAll(houseRightsMap);
        }
    }


    public static class Identity extends Dogma.Identity<Identity, Agent,Representative,AgentAttributes> {

        public Identity(String s, Index<Path_ofInfo> index) {
            super(s, index);
        }
    }

    public static class Representative extends Dogma.Representative<Identity,Agent,Representative,AgentAttributes> {

        public Representative(Agent addressed, Resource resource) {
            super(addressed, resource);
        }
    }

    public static class AgentAttributes extends DogmaAttributes<Agent.Identity, Agent,Representative,AgentAttributes> {

        public AgentAttributes(Properties properties, long size) {
            super(properties, size);
        }
    }
    public static class Resource extends Dogma.Resource<Identity,Agent,Representative,AgentAttributes> {

        public Resource(Standard standard, Function<Representative, Representative> graveDigger, Specification specification) {
            super(standard, graveDigger, specification);
        }
    }
}
