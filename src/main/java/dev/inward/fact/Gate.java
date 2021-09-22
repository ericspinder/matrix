package dev.inward.fact;

import dev.inward.morph.CreationMorph;
import dev.inward.morph.Morph;
import lombok.Getter;

@Getter
public abstract class Gate extends Fact {

    private final List<Morph<MagicWord,?, ?>> magicWords;

    public Gate(CreationMorph creationMorph) {
        super(creationMorph);
    }
}
