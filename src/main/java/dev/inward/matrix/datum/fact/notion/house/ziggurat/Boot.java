package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.boot.Init;
import dev.inward.matrix.datum.fact.notion.concept.boot.Structure;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public class Boot extends Fabrication<Boot, Ziggurat, Init, Structure, Root> {

    public Boot(Root mortal, Storage storage, Map<Standard<?, dev.inward.matrix.datum.fact.notion.concept.boot.Boot, Identity.Ego, Context.Demarc>, Resource<Boot, ?, ?, ?, dev.inward.matrix.datum.fact.notion.concept.boot.Boot, Init, Identity.Ego, Context.Demarc, Structure, Root>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}