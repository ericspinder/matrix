package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.house.House;
import dev.inward.matrix.domain.Authority;
import dev.inward.matrix.resources.LocalSystemNetworking;
import dev.inward.matrix.resources.OSinfo;

import java.util.HashMap;
import java.util.Map;

public class Ziggurat extends House<Ziggurat,Root> {

    protected final OSinfo oSinfo = new OSinfo();
    protected final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    protected final Map<Context.Ethereal, Authority> etherealAuthorityMap = new HashMap<>();

    protected Ziggurat(Identity.Ghost ghost) {
        super(ghost);

    }
    public void startup() {
        Startup.
    }


}
