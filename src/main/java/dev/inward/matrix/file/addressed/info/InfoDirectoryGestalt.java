/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.DirectoryGestalt;

import java.util.function.Function;

public class InfoDirectoryGestalt extends DirectoryGestalt<InfoScheme,InfoLibraryKey,InfoLibrary,InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference, InfoDirectoryView, InfoDirectoryGestalt,InfoDirectoryModel> {

    public InfoDirectoryGestalt(Function<InfoDirectoryReference, InfoDirectoryReference> graveDigger, InfoDirectoryModel model, Class<InfoDirectoryView> viewClass) {
        super(graveDigger, model,viewClass);
    }
}
