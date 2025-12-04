/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.http;

import dev.inward.matrix.concept.file.directory.DirectoryLibrarian;
import dev.inward.matrix.concept.file.addressed.depot.standard.Standard;

public class HttpDirectoryLibrarian extends DirectoryLibrarian<HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel, HttpDirectoryReference, HttpDirectoryLibrarian,String> {

    public HttpDirectoryLibrarian(Standard standard) {
        super(standard);
    }
}
