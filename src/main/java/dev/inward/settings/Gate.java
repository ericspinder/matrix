package dev.inward.settings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Gate extends Setting {

    private Settings<MagicWord> magicWords;

}
