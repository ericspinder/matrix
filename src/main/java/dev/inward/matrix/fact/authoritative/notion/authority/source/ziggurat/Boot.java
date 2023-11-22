package dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.boot.Structure;
import dev.inward.matrix.fact.authoritative.notion.house.Assembly;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public class Boot extends Assembly<Boot, Ziggurat, Init, Structure, Root> {

    public Boot(Root mortal, Storage storage, Map<Standard<?, dev.inward.matrix.fact.authoritative.notion.concept.boot.Boot, Identity.Ego, Context.Demarc>, Resource<Boot, ?, ?, ?, dev.inward.matrix.fact.authoritative.notion.concept.boot.Boot, Init, Identity.Ego, Context.Demarc, Structure, Root>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}