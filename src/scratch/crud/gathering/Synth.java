/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.gathering;

import dev.inward.matrix.meta.Meta;
import dev.inward.matrix.setting.Setting;

import java.io.Serializable;

public class Synth<DATUM extends Comparable<DATUM> & Serializable, S extends Synth<DATUM,S>> extends Setting {

    private Class<DATUM> dClass;
    private String description;
    private String i18n;
    Meta

}
