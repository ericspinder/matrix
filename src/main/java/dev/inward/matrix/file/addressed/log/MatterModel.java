/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.AddressedModel;

import java.util.UUID;

public class MatterModel extends AddressedModel<Matter,UUID,MatterKey,MatterView,MatterModel,MatterReference,MatterLibrarian,LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian,LogPath> {
    public MatterModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
