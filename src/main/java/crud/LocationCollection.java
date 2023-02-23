package crud;

import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.concept.*;
import dev.inward.matrix.fact.datum.protocol.NetworkContact;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Map;

public class LocationCollection<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,E,V,M>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,E,V,M>,C extends Concept<C,M>,E extends Effect<FAB,C,E,V,M>,V extends Volume<FAB,C,E,V,M>,M extends Mortal<FAB,C,E,V,M>> extends PermissionCollection {

    protected Map<Location, NetworkContact> locationNetworkConnectionMap;


    @Override
    public void add(Permission permission) {
        if (! (permission instanceof Location)) {
            //Send error
        }
    }
    public void add(Location location) {

    }
    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return null;
    }
}
