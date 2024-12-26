package dev.inward.matrix.log;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

public class Scheme_ofLog extends Scheme<Scheme_ofLog, Library_ofLog, Library_ofLog.Pathway> {

    public static final Scheme_ofLog EARTH_SCHEME_OF_LOG = new Scheme_ofLog(Terrene.Earth);
    public static final Scheme_ofLog TERRENE_SCHEME_OF_LOG = new Scheme_ofLog(Terrene.Luna);
    public static final Scheme_ofLog MARS_SCHEME_OF_LOG = new Scheme_ofLog(Terrene.Mars);
    public static final Scheme_ofLog CHAOSNET_SCHEME_OF_LOG = new Scheme_ofLog(Terrene.Chaosnet);
    public static final Scheme_ofLog HELIOS_SCHEME_OF_LOG = new Scheme_ofLog(Terrene.Helios);
    protected Scheme_ofLog(Terrene terrene) {
        super(terrene,Protocol.LOG);
    }
}
