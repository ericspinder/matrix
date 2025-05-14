/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedReference;

import java.util.UUID;

public class MatterReference extends AddressedReference<Matter,UUID,MatterKey,MatterView,MatterModel,MatterReference,MatterLibrarian,LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian,LogPath> {
    public MatterReference(Matter addressed, MatterLibrarian resource) {
        super(addressed, resource);
    }
}
