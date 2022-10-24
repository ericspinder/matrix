package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Authority;
import dev.inward.matrix.resources.LocalSystemNetworking;
import dev.inward.matrix.resources.OSinfo;

import java.util.HashMap;
import java.util.Map;

public class Ziggurat extends House<> {

    protected final OSinfo oSinfo;
    protected final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    protected final Map<Context.Ethereal, Authority> etherealAuthorityMap = new HashMap<>();


}
