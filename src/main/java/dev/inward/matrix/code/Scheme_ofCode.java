package dev.inward.matrix.code;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

public class Scheme_ofCode extends Scheme<Scheme_ofCode,Library_ofCode,Path_ofCode> {

    public static final Scheme_ofCode EARTH_SCHEME_OF_CODE = new Scheme_ofCode(Terrene.Earth);
    public static final Scheme_ofCode LUNA_SCHEME_OF_CODE = new Scheme_ofCode(Terrene.Luna);
    public static final Scheme_ofCode MARS_SCHEME_OF_CODE = new Scheme_ofCode(Terrene.Mars);
    public static final Scheme_ofCode CHAOSNET_SCHEME_OF_CODE = new Scheme_ofCode(Terrene.Chaosnet);
    public static final Scheme_ofCode HELIOS_SCHEME_OF_CODE = new Scheme_ofCode(Terrene.Helios);

    protected Scheme_ofCode(Terrene terrene) {
        super(terrene,Protocol.CODE);
    }
}
